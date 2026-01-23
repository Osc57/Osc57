select * from investigadores order by facultad DESC;

select nombre as NombreInvestigador, apellidos as ApellidosInvestigador, dni as DNI from investigadores order by apellidos;

select * from facultades where NomFacultad like '%Ciencias%';

select * from equipos where IdFacultad  = 3;

select * from equipos where IdEquipo like 'H%';

select * from equipos where IdEquipo not like 'H%';

select * from investigadores where facultad in (2,4);

select * from reservas where FInicio like '2024-11-%';
select * from reservas where FInicio >= '2024-11-01' and FFin <= '2024-11-30';

