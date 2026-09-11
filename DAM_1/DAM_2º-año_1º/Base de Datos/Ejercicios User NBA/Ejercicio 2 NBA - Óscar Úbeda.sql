/*Ejercicios NBA usuarios Óscar Úbeda*/

/*Ej1*/
mysql> CREATE USER GESTION IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.06 sec)

/*Ej2*/
mysql> GRANT ALL PRIVILEGES ON nba.* TO GESTION;
Query OK, 0 rows affected (0.01 sec)

/*Ej3*/
C:\Users\dam1>mysql -u GESTION -p
Enter password: ****

mysql> USE nba;
Database changed
mysql> SELECT * FROM equipos;
+-----------+---------------+--------------+-------------+-----------+----------------------------+-----------+--------+------+------+
| id_equipo | nombre        | ciudad       | conferencia | division  | pabellon                   | capacidad | puntos | pp   | pg   |
+-----------+---------------+--------------+-------------+-----------+----------------------------+-----------+--------+------+------+
|         1 | Celtics       | Boston       | East        | Atlantic  | TD Garden                  |        19 |     39 |   16 |   39 |
|         2 | Raptors       | Toronto      | East        | Atlantic  | Scotiabank Arena           |     19800 |     17 |   38 |   17 |
|         3 | 76ers         | Philadelphia | East        | Atlantic  | Wells Fargo center         |     20007 |     20 |   34 |   20 |
|         4 | Nets          | Brooklyn     | East        | Atlantic  | Barclays Center            |     17732 |     20 |   34 |   20 |
|         5 | Knicks        | New York     | East        | Atlantic  | Madison Square Garden      |     19812 |     36 |   18 |   36 |
|         6 | Pistons       | Detroit      | East        | Central   | Little Caesars Arena       |     20332 |     29 |   26 |   29 |
|         7 | Cavaliers     | Cleveland    | East        | Central   | Rocket Mortgage FieldHouse |     19432 |     44 |   10 |   44 |
|         8 | Pacers        | Indiana      | East        | Central   | Gainbridge Fieldhouse      |     17923 |     30 |   23 |   30 |
|         9 | Bulls         | Chicago      | East        | Central   | United Center              |     20917 |     22 |   33 |   22 |
|        10 | Bucks         | Milwaukee    | East        | Central   | Fiserv Forum               |     17341 |     29 |   24 |   29 |
|        11 | Magic         | Orlando      | East        | SouthEast | Kia Center                 |     18846 |     27 |   29 |   27 |
|        12 | Wizards       | Washington   | East        | SouthEast | Capital One Arena          |     20333 |      9 |   45 |    9 |
|        13 | Hawks         | Atlanta      | East        | SouthEast | State Farm Arena           |     17044 |     26 |   29 |   26 |
|        14 | Bobcats       | New Orleans  | East        | SouthEast | Smoothie King Center       |     16867 |     13 |   42 |   13 |
|        15 | Heat          | Miami        | East        | SouthEast | Kaseya Center              |     19600 |     25 |   28 |   25 |
|        16 | Jazz          | Utah         | West        | NorthWest | Delta Center               |     18306 |     13 |   41 |   13 |
|        17 | Nuggets       | Denver       | West        | NorthWest | Ball Arena                 |     19250 |     36 |   19 |   36 |
|        18 | Trail Blazers | Portland     | West        | NorthWest | Moda Center                |     19411 |     23 |   32 |   23 |
|        19 | Timberwolves  | Minnesota    | West        | NorthWest | Target Center              |     18024 |     31 |   25 |   31 |
|        20 | Supersonics   | Seattle      | West        | NorthWest | Seattle Center             |     19000 |     11 |   30 |   11 |
|        21 | Lakers        | Los Angeles  | West        | Pacific   | Crypto.com Arena           |     18997 |     32 |   20 |   32 |
|        22 | Suns          | Phoenix      | West        | Pacific   | Footprint Center           |     17071 |     26 |   28 |   26 |
|        23 | Warriors      | Golden State | West        | Pacific   | Chase Center               |     18064 |     28 |   27 |   28 |
|        24 | Kings         | Sacramento   | West        | Pacific   | Golden 1 Center            |     17611 |     28 |   27 |   28 |
|        25 | Clippers      | Los Angeles  | West        | Pacific   | Intuit Dome                |     18000 |     31 |   23 |   31 |
|        26 | Hornets       | Charlotte    | West        | SouthWest | Spectrum Center            |     19077 |     13 |   39 |   13 |
|        27 | Spurs         | San Antonio  | West        | SouthWest | Frost Bank Center          |     18354 |     23 |   29 |   23 |
|        28 | Rockets       | Houston      | West        | SouthWest | Toyota Center              |     18055 |     34 |   21 |   34 |
|        29 | Mavericks     | Dallas       | West        | SouthWest | American Airlines Center   |     19200 |     30 |   26 |   30 |
|        30 | Grizzlies     | Memphis      | West        | SouthWest | FedExForum                 |     17794 |     36 |   18 |   36 |
+-----------+---------------+--------------+-------------+-----------+----------------------------+-----------+--------+------+------+
30 rows in set (0.01 sec)

/*Ej4*/
C:\Users\dam1>mysql -u root -p
Enter password: ****
mysql> GRANT CREATE VIEW, INDEX ON NBA.* TO GESTION;
Query OK, 0 rows affected (0.01 sec)

/*Ej5*/
C:\Users\dam1>mysql -u GESTION -p
Enter password: ****
mysql> use nba;
CREATE VIEW vista_jugadores_lakers AS SELECT nombre FROM jugadores WHERE codigo = (
    -> SELECT id_equipo FROM equipos WHERE nombre = 'Lakers');
Query OK, 0 rows affected (0.02 sec)

/*Ej6*/
mysql> EXPLAIN SELECT * FROM vista_jugadores_lakers;
+----+-------------+-----------+------------+-------+---------------+---------+---------+-------+------+----------+-------------+
| id | select_type | table     | partitions | type  | possible_keys | key     | key_len | ref   | rows | filtered | Extra       |
+----+-------------+-----------+------------+-------+---------------+---------+---------+-------+------+----------+-------------+
|  1 | PRIMARY     | jugadores | NULL       | const | PRIMARY       | PRIMARY | 4       | const |    1 |   100.00 | NULL        |
|  3 | SUBQUERY    | equipos   | NULL       | ALL   | NULL          | NULL    | NULL    | NULL  |   30 |    10.00 | Using where |
+----+-------------+-----------+------------+-------+---------------+---------+---------+-------+------+----------+-------------+
2 rows in set, 1 warning (0.01 sec)

/*Ej7*/
mysql> CREATE INDEX index_id_equipo ON jugadores(equipo);
Query OK, 0 rows affected (0.06 sec)
Records: 0  Duplicates: 0  Warnings: 0

/*Ej8*/
mysql> SELECT * FROM vista_jugadores_lakers; EXPLAIN SELECT * FROM vista_jugadores_lakers;
+-------------+
| nombre      |
+-------------+
| Elton Brand |
+-------------+
1 row in set (0.00 sec)

+----+-------------+-----------+------------+-------+---------------+---------+---------+-------+------+----------+-------------+
| id | select_type | table     | partitions | type  | possible_keys | key     | key_len | ref   | rows | filtered | Extra       |
+----+-------------+-----------+------------+-------+---------------+---------+---------+-------+------+----------+-------------+
|  1 | PRIMARY     | jugadores | NULL       | const | PRIMARY       | PRIMARY | 4       | const |    1 |   100.00 | NULL        |
|  3 | SUBQUERY    | equipos   | NULL       | ALL   | NULL          | NULL    | NULL    | NULL  |   30 |    10.00 | Using where |
+----+-------------+-----------+------------+-------+---------------+---------+---------+-------+------+----------+-------------+
2 rows in set, 1 warning (0.00 sec)

/*Ej9*/
C:\Users\dam1>mysql -u root -p
Enter password: ****
mysql> use nba;
mysql> CREATE VIEW vista_promedio_puntos AS SELECT jugador, AVG(puntos_por_partido) AS promedio FROM estadisticas GROUP BY jugador;
Query OK, 0 rows affected (0.01 sec)

/*Ej10*/
mysql> GRANT SELECT ON vista_promedio_puntos TO GESTION;
Query OK, 0 rows affected (0.02 sec)

/*Ej11*/
C:\Users\dam1>mysql -u GESTION -p
Enter password: ****
USE nba;
mysql> SELECT * FROM vista_promedio_puntos LIMIT 10;
+---------+--------------------+
| jugador | promedio           |
+---------+--------------------+
|       1 |  5.599999904632568 |
|       2 |  5.311111026340061 |
|       3 |  4.679999995231628 |
|       4 | 11.600000381469727 |
|       5 | 10.766666889190674 |
|       6 |  7.866666714350383 |
|       7 | 12.899999976158142 |
|       8 |  2.062499985098839 |
|       9 |  9.266666571299234 |
|      10 |  1.899999976158142 |
+---------+--------------------+
10 rows in set (0.01 sec)




