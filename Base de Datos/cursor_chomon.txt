DELIMITER //
CREATE PROCEDURE menor (IN introduce_curso VARCHAR(10))
BEGIN

DECLARE num_exp INT;
DECLARE edad INT;
DECLARE final_filas BOOLEAN DEFAULT 0;
DECLARE cursor1 CURSOR FOR SELECT expte, años FROM alumnos WHERE curso=introduce_curso;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET final_filas=1;

DROP TABLE IF EXISTS menores;
CREATE TABLE menores(expte INT PRIMARY KEY, edad INT, curso VARCHAR(10), FOREIGN KEY (expte) REFERENCES alumnos(expte));

OPEN cursor1;
miloop:LOOP
FETCH cursor1 INTO num_exp, edad;

IF (final_filas=1) THEN LEAVE miloop;
END IF;

IF (edad<18) THEN INSERT INTO menores VALUES (num_exp, edad, introduce_curso);
END IF;

END LOOP miloop;
CLOSE cursor1;

END//
DELIMITER ;