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
