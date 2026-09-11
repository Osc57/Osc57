-- Ejercicio 1
CREATE PROCEDURE bares.resumen_bar(IN p_cod_bar CHAR(3))
BEGIN
	-- Declaramos variables
	DECLARE vNombreBar VARCHAR(15);
	DECLARE vLocalidadBar VARCHAR(15);
	DECLARE vNumeroTotalRepartos INT;
	DECLARE vCantidadUnidades INT;
	DECLARE vFechaMasReciente DATE;

	SELECT nombre, localidad INTO vNombreBar, vLocalidadBar
	FROM bares WHERE cod_bar=p_cod_bar;
	
	
	-- Comprobar si existe
	IF vNombreBar IS NULL THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'error: el bar no existe';
	ELSE
		SELECT COUNT(cod_bar), SUM(cantidad), MAX(fecha)
		INTO vNumeroTotalRepartos, vCantidadUnidades, vFechaMasReciente
		FROM reparto WHERE cod_bar=p_cod_bar;
	
		-- Mostrar resultados
		SELECT CONCAT('Bar ', vNombreBar, ' localidad ', vLocalidadBar) 
		AS Informe;
		SELECT vNumeroTotalRepartos AS Total_repartos,
			vCantidadUnidades AS Total_unidades,
			vFechaMasReciente AS Fecha_ultimo_reparto;	
	END IF;
END;

-- Ejercicio 2
CREATE FUNCTION bares.nivel_stock(p_cod_cerv CHAR(2))
RETURNS VARCHAR(25)
DETERMINISTIC
BEGIN
	-- Declaramos variables
	DECLARE v_stock INT;
	DECLARE v_cod_cerv CHAR(2);

	-- Recuperamos el stock y el cod_cerveza
	SELECT cod_cerv, stock 
	INTO v_cod_cerv, v_stock 
	FROM cervezas 
	WHERE cod_cerv=p_cod_cerv;
	
	-- Comprobar si existe
	IF v_cod_cerv IS NULL THEN
		RETURN 'No existe';
	END IF;
	
	IF  v_stock > 2000 THEN
        RETURN 'Alto';
    ELSEIF v_stock BETWEEN 500 AND 2000 THEN
        RETURN 'Medio';
    ELSEIF v_stock >= 1 THEN
        RETURN 'Bajo';
    ELSE
        RETURN 'Agotado';
    END IF;
	
END;

-- Ejercicio 3
CREATE PROCEDURE bares.sp_alerta_reposicion(IN p_cod_prov CHAR(3))
BEGIN
	-- Declaramos variables
	DECLARE v_cod_cerv CHAR(2);
	DECLARE v_envase  VARCHAR(10);
    DECLARE v_precio_unidad DECIMAL(6,2);
    DECLARE v_ultimo_pedido DATE;
    
	DECLARE v_nombre_prov   VARCHAR(30);
    DECLARE v_nivel         VARCHAR(10);

    DECLARE v_cnt_alerta    INT DEFAULT 0;
    DECLARE v_cnt_ok        INT DEFAULT 0;
    DECLARE v_cnt_total     INT DEFAULT 0;
    
    DECLARE v_ultima_fila BOOLEAN DEFAULT FALSE;
    
    -- Declaramos el cursor
    DECLARE cursor_suministra CURSOR FOR
    	SELECT s.cod_cerv, c.envase, s.precio_unidad,
    	s.ultimo_pedido
    	FROM suministra s
    	JOIN cervezas c ON s.cod_cerv=c.cod_cerv
    	WHERE s.cod_prov=p_cod_prov;
    
    -- Declaramos el manejador para el cursor
    DECLARE CONTINUE HANDLER FOR NOT FOUND 
     SET v_ultima_fila = TRUE; 
    
	-- Comprobamos que el proveedor existe
    SELECT nombre INTO v_nombre_prov
    FROM proveedores
    WHERE cod_prov=p_cod_prov;
	
	IF v_nombre_prov IS NULL THEN
		SIGNAL SQLSTATE '45020'
            SET MESSAGE_TEXT = 'ERROR: El código de proveedor indicado no existe.';
    END IF;
	
	-- Encabezado del informe
	SELECT CONCAT('Informe de reposición — Proveedor: ',
                  v_nombre_prov, ' (', p_cod_prov, ')') AS encabezado;
	
	-- Abrimos el cursor 
	OPEN cursor_suministra;
	
	-- Recorremos el cursor 
	bucle:LOOP
		FETCH cursor_suministra
		 INTO v_cod_cerv, v_envase,v_precio_unidad, v_ultimo_pedido;
		
		IF v_ultima_fila THEN
			LEAVE bucle;
		END IF;
		
		-- Contar cervezas
		SET v_cnt_total=v_cnt_total+1;
		
		SET v_nivel = nivel_stock(v_cod_cerv);
		
		IF v_nivel IN ('Bajo', 'Agotado') THEN
			SELECT CONCAT(
                       '>> ALERTA: Cerveza ', v_cod_cerv,
                       ' (', v_envase, ')',
                       ' — nivel: ', v_nivel,
                       ' | Precio prov.: ', v_precio_unidad, ' €',
                       ' | Último pedido: ', v_ultimo_pedido
                   ) AS estado_cerveza;
		    SET v_cnt_alerta =v_cnt_alerta+1;
		ELSE 
			SELECT CONCAT(
                       'OK: Cerveza ', v_cod_cerv,
                       ' (', v_envase, ')',
                       ' — nivel: ', v_nivel
                   ) AS estado_cerveza;
			SET v_cnt_ok =v_cnt_ok+1;
		END IF;
	END LOOP;
	-- Cerramos el cursor
	CLOSE cursor_suministra;
	
	IF v_cnt_total = 0 THEN
        SELECT CONCAT('El proveedor ', v_nombre_prov,
                      ' no tiene cervezas asignadas.') AS aviso;
    ELSE
        -- ── Resumen final
        SELECT v_cnt_alerta AS cervezas_necesitan_reposicion,
               v_cnt_ok     AS cervezas_en_nivel_correcto,
               v_cnt_total  AS total_cervezas_proveedor;
    END IF;
	
END

-- Ejercicio 4
CREATE DEFINER=`root`@`localhost` TRIGGER `trg_borrar_cerveza` BEFORE DELETE ON `cervezas` FOR EACH ROW BEGIN
	DECLARE v_tiene_repartos INT;

	-- Comprobamos si existe algún reparto con esta cerveza
    SELECT COUNT(*)
      INTO v_tiene_repartos
      FROM reparto
     WHERE cod_cerv = OLD.cod_cerv;
	
	IF v_tiene_repartos > 0 THEN
        SIGNAL SQLSTATE '45001'
            SET MESSAGE_TEXT = 'ERROR: No se puede eliminar la cerveza porque tiene repartos asociados.';
    END IF;
	
	INSERT INTO auditoria_cervezas (usuario, cod_cerv, envase, capacidad)
    VALUES (CURRENT_USER(), OLD.cod_cerv, OLD.envase, OLD.capacidad);
	
END

-- Ejercicio 5
CREATE DEFINER=`root`@`localhost` TRIGGER `trg_insertar_reparto` BEFORE INSERT ON `reparto` FOR EACH ROW BEGIN
	DECLARE v_stock_actual SMALLINT;

	SELECT stock
      INTO v_stock_actual
      FROM cervezas
     WHERE cod_cerv = NEW.cod_cerv;
	
	-- ── Validación 1: cantidad debe ser positiva
    IF NEW.cantidad <= 0 THEN
        SIGNAL SQLSTATE '45010'
            SET MESSAGE_TEXT = 'ERROR: La cantidad del reparto debe ser mayor que 0.';

    -- ── Validación 2: la fecha no puede ser futura
    ELSEIF NEW.fecha > CURDATE() THEN
        SIGNAL SQLSTATE '45011'
            SET MESSAGE_TEXT = 'ERROR: La fecha del reparto no puede ser posterior a la fecha actual.';

    -- ── Validación 3: stock suficiente
    

    ELSEIF NEW.cantidad > v_stock_actual THEN
        SIGNAL SQLSTATE '45012'
            SET MESSAGE_TEXT = 'ERROR: La cantidad solicitada supera el stock disponible de la cerveza.';
    END IF;
    
    UPDATE cervezas
       SET stock = stock - NEW.cantidad
     WHERE cod_cerv = NEW.cod_cerv;
END


