select * from investigadores order by facultad DESC;

select nombre as NombreInvestigador, apellidos as ApellidosInvestigador, dni as DNI from investigadores order by apellidos;

select * from facultades where NomFacultad like '%Ciencias%';

select * from equipos where IdFacultad  = 3;

select * from equipos where IdEquipo like 'H%';

select * from equipos where IdEquipo not like 'H%';

select * from investigadores where facultad in (2,4);

select * from reservas where FInicio like '2024-11-%';
select * from reservas where FInicio >= '2024-11-01' and FFin <= '2024-11-30';

select * from investigadores where apellidos like '%o%z' order by apellidos; 

select nombre, apellidos from investigadores where beca > 8000;

select nombre as NomInvestigador, apellidos as ApeInvestifador from investigadores order by apellidos;  

select dni from reservas where FInicio like '%-09-%';

select dni, beca, beca * 1.05 as Nueva_Cuantia from investigadores order by nueva_cuantia desc;

select descripcion from equipos where IdEquipo = 'H555';

-- Visualiza los nombres de los investigadores que están en la facultad de Ciencias Matematicas.
select nombre from investigadores where facultad = (select idfacultad from facultades 
where nomfacultad = 'Ciencias Matematicas');


-- Visualiza todos los datos de las reservas del equipo de Descripción Telemetro laser SICK
select * from reservas where IdEquipo = (select IdEquipo from equipos 
where Descripcion = 'Telemetro laser SICK');

-- Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias Geologicas
select * from reservas where dni in (select dni from investigadores 
where facultad = (select idfacultad from facultades 
where NomFacultad = 'Ciencias Geologicas'));

-- Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas con un sueldo entre 2000 y 6000.
select * from reservas where dni in (select dni from investigadores 
where facultad = (select idfacultad from facultades 
where NomFacultad = 'Ciencias Geologicas') and beca between 2000 and 6000);

-- Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas, que hayan escogido el equipo H222
select * from reservas where dni in (select dni from investigadores 
where dni in (select dni from investigadores 
where facultad = (select idfacultad from facultades 
where NomFacultad = 'Ciencias Geologicas'))) and IdEquipo = 'H222';

-- Visualiza los datos de las reservas de los investigadores que están en la facultad de Ciencias
-- Geologicas, que hayan escogido equipos de la Facultad de Ciencias Químicas.
select * from reservas where dni in (select dni from investigadores 
where facultad in (select IdFacultad  from facultades 
where nomfacultad = 'Ciencias Geologicas')) and idequipo in (select idequipo from equipos 
where idfacultad = (select idfacultad from facultades 
where nomfacultad = 'Ciencias Quimicas'));





















