/*1. Crea una función que calcule el campo importe de una llamada cuyo identificador se pasara
como parámetro. El importe se calcula de la siguiente manera:
importe=duración*minutos+establecimiento.
Pero, hay que tener en cuenta que los minutos pueden ser de móviles o fijos. Que cada
cliente tiene asociada una tarifa. Además si la llamada es internacional se aplica un
aumento del 2%.*/

CREATE FUNCTION calcularImporte(p_id_llamada INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_duracion INT;
    DECLARE v_tipo VARCHAR(20);
    DECLARE v_destino VARCHAR(50);
    DECLARE v_minuto DECIMAL(10,4);
    DECLARE v_establecimiento DECIMAL(10,2);
    DECLARE v_importe DECIMAL(10,2);

   
    SELECT l.duracion, l.tipo, l.destino, t.establecimiento,
           CASE WHEN l.tipo = 'M' THEN t.minuto_movil ELSE t.minuto_fijo END
    INTO v_duracion, v_tipo, v_destino, v_establecimiento, v_minuto
    FROM llamadas l
    JOIN clientes c ON l.id_cliente = c.id_cliente
    JOIN tarifas t  ON c.tarifa = t.id_tarifa
    WHERE l.id_llamada = p_id_llamada;

    IF v_duracion IS NULL THEN
        RETURN 0;
    END IF;

    SET v_importe = (v_duracion * v_minuto) + v_establecimiento;

    IF UPPER(v_destino) = 'I' THEN
        SET v_importe = v_importe * 1.02;
    END IF;

    RETURN ROUND(v_importe, 2);
END

/*2. Crea un procedimiento que actualice el campo importe de todas las llamadas. Utiliza un
cursor y la función del ejercicio anterior. El procedimiento tiene que mostrar un mensaje
tipo “El cliente <cliente> en la llamada <id_llamada> tiene un gasto de <importe>”. Prueba
el procedimiento*/

/*3. Crea un procedimiento para visualizar para cada una de las tarifas, la lista de los clientes de
las mismas. Utilizar doble cursor. Visualiza el nombre de la tarifa, la lista de los clientes con
el nombre, apellidos. Además hay que visualizar el total de clientes de cada tarifa y la suma
de los importes de todos los clientes en cada tarifa.*/

/*4. Crear un trigger para validar los datos al insertar un cliente. El nif debe tener exactamente
dos dígitos (utiliza la función LENGHT). La edad debe estar comprendida entre 18 y 100
años. El cliente no puede ser padrino de sí mismo. Establece errores personalizados.
Prueba el trigger.*/










































