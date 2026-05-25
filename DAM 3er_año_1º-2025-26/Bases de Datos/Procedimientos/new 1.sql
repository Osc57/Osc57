DELIMITER //
CREATE PROCEDURE empresa.listEmpleadosConHijos()
BEGIN
	SELECT * FROM empleado WHERE NumHi > 0;
END
DELIMITER ;

CALL listEmpleadosConHijos();