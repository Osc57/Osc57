/*1. Crea un procedimiento de nombre listEmpleadosConHijos que muestre los empleados que
tienen hijos.*/
create procedure empresa.listEmpleadosConHijos()
begin
	select NomEmp from empleado where NumHi > 0;
end

/* 2. Crea un procedimiento de nombre contarEmpleados que muestre la cantidad de
empleados */

CREATE PROCEDURE empresa.contarEmpleados()
BEGIN
	select count(*) from empleado;
END


/*3. Crea un procedimiento de nombre updSalarioEmpleados que incremente el salario de los
empleados un 10%.*/

CREATE PROCEDURE empresa.updSalarioEmpleados()
BEGIN
    UPDATE empresa.empleado 
    SET SalEmp = SalEmp * 1.10;
end

/*4. Crea un procedimiento de nombrelistDepartamentos que liste los departamentos de un
determinado centro. Habrá que pasar como parámetro el nombre del centro*/
create procedure empresa.nombrelistDepartamentos(in centro VARCHAR(150))
BEGIN
	
	DECLARE v_CodCen INT;

    SELECT CodCen INTO v_CodCen 
    FROM centro 
    WHERE NomCen = centro 
    LIMIT 1;

    IF v_CodCen IS NULL THEN
        SELECT 'No hay departamentos para el centro' AS Mensaje;
    ELSE
        SELECT NomDep 
        FROM departamento 
        WHERE CodCen = v_CodCen;
    END IF;
end


/*6. Crea un procedimiento de nombre updSalarioEmpleadosParam que incremente el salario
de los empleados una determinada cantidad a partir de un parámetro de entrada.*/

CREATE PROCEDURE empresa.updSalarioEmpleadosParam(in salario decimal(12,2))
BEGIN
    UPDATE empresa.empleado 
    SET SalEmp = SalEmp + cantidad_aumento;
end

/*10. Crea un procedimiento de nombre sueldosSelectInto que devuelva el sueldo menor, el
mayor y el promedio de todos los empleados (usando una única sentencia SELECT INTO)*/

CREATE PROCEDURE empresa.sueldosSelectInto()
BEGIN
     
end
