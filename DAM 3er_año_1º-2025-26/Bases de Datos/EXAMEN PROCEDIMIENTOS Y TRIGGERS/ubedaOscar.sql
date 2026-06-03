/*EXÁMEN PRUEBA UNIDAD 10 - UNIDAD 11 - ÓSCAR ÚBEDA*/

/*1. Crea un procedimineto llamado resumen_bar al que se le pase como parámetro el código de un bar. El
procedimiento debera mostrar la siguiente información:
	• El nombre del bar y su localidad
	• El número total de repartos realizados en ese bar
	• La cantidad total de unidades recibidas
	• La fecha del reparto más reciente realizado en ese bar
 */

CREATE PROCEDURE bares.resumen_bar(in p_code_bar CHAR(3))
begin
	
	declare bar_no_valido condition for sqlstate '45000'; -- Genero variable de gestión de error
	
	if p_code_bar not in (select cod_bar from bares) then -- Compruebo que el codigo pasado por parámetro no este la tabla de bares
		signal bar_no_valido set message_text = 'EL bar no existe';
	else
		SELECT CONCAT('Bar ', b.nombre , ' Localidad ' , b.localidad ) as Informe FROM bares b WHERE cod_bar = p_code_bar;
		select COUNT(r.cod_cerv) as Total_repartos, SUM(r.cantidad) as Total_unidades, MAX(r.fecha) as Fecha_ultimo_reparto from reparto r join bares b on r.cod_bar = b.cod_bar where b.cod_bar = p_code_bar group by b.cod_bar;
	end if;

end

/*2. Crea una función llamada nivel_stock que reciba el código de una cerveza (p_cod_cerv) y devuelva un texto
 indicando el nivel de stock según estas condiciones:
 	• stock > 2000 -> Alto
 	• stock entre 500 y 2000 -> Medio
 	• stock entre 1 y 499 -> Bajo
 	• stock = 0 -> Agotado
 */

/*RETURNS VARCHAR(100)*/

CREATE FUNCTION bares.nivel_stock(p_cod_cerveza CHAR(2))
returns varchar(100)
deterministic
reads sql data
begin
	
	declare v_stock INT;
	
	select stock into v_stock from cervezas where cod_cerv = p_cod_cerveza;
	
	IF v_stock IS NULL THEN
        RETURN 'No existe';
	ELSEIF v_stock > 2000 THEN
        RETURN 'Alto';
    ELSEIF v_stock BETWEEN 500 AND 2000 THEN
        RETURN 'Medio';
    ELSEIF v_stock BETWEEN 1 AND 499 THEN
        RETURN 'Bajo';
    ELSE
        RETURN 'Sin stock (0)';
    END IF;
		
end

/*4. Crea una tabla auditoria llamada auditoria_cervezas con los campos:
 id(AUTO_INCREMENT), tabla_afectada, fecha_hora, usuario, cod_cerv, envase, capacidad, operacion.
 Identifica la clave primaria e indicala
 Crea a continuación un trigger llamado trg_borrar_cerveza que se dispare antes de borrar sobre la tabla
 cervezas y que:
 	• Impida el borrado si la cerveza tiene registros en la tabla reparto, lanzando un error personalizado.
 	• Si el borrado es válido, registre la operación en la tabla auditoria_cervezas antes de que se 
 	complete.
 Prueba el trigger:
 	a) Intentando borrar una cerveza que SI tiene repartos
 	b) Borrando una cerveza que NO tiene repartos (inserta previamente una cerveza de prueba si es
 	necesario).
 */

create table auditoria_cerveza( -- Creo la tabla de auditoria
	id INT auto_increment primary key,
	tabla_afectada VARCHAR(100),
	fecha_hora DATETIME,
	usuario VARCHAR(100),
	cod_cerv CHAR(2),
	envase VARCHAR(100),
	capacidad INT,
	operacion VARCHAR(100)
);

create trigger trg_borrar_cerveza before delete
on cervezas for each row
begin
	
	declare impedir_borrado condition for sqlstate '45000';
	
	if old.cod_cerv in (select cod_cerv from reparto) then -- Compruebo si el codigo de cerveza esta en la tabla reparto
		signal impedir_borrado set message_text = 'La cerveza tiene repartos';
	else if
	-- Si el codigo no esta realizo la insercion en la tabla auditoria_cerveza
		insert into auditoria_cerveza (tabla_afectada, fecha_hora, usuario, cod_cerv, envase, capacidad, operacion) values ('cervezas', NOW(), 'admin', old.cod_cerv, old.envase, old.capacidad, 'inserción');
	end if;
end

-- Me genero unas cerveza prueba

INSERT INTO cervezas (cod_cerv, envase, capacidad, stock) VALUES ('13', 'barril', 65.00, 6700);
INSERT INTO cervezas (cod_cerv, envase, capacidad, stock) VALUES ('14', 'botella', 1.15, 700);


































