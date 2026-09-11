/*PRUEBA PARA PRACTICAR UD6-UD7 TELEFONÍA - ÓSCAR ÚBEDA*/
/*Ej1*/
mysql> SELECT nombre, apellidos FROM clientes WHERE padrino IN (SELECT MAX(edad) FROM clientes) AND tarifa IN (SELECT id_tarifa FROM tarifas);
Empty set (0.007 sec)

/*Ej2*/
