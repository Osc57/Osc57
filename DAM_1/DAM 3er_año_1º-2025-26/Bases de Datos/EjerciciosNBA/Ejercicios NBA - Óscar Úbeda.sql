/*Ejercicios NBA - Óscar Úbeda*/

-- Ej1
mysql> SELECT DISTINCT nombre FROM jugadores ORDER BY nombre LIMIT 10;
+----------------+
| nombre         |
+----------------+
| Aaron Brooks   |
| Aaron Gray     |
| Aaron Mckie    |
| Acie Law       |
| Adam Morrison  |
| Adonal Foyle   |
| Adrian Griffin |
| Al Harrington  |
| Al Horford     |
| Al Jefferson   |
+----------------+
10 rows in set (0.007 sec)

-- Ej2
mysql> SELECT nombre, equipo, altura FROM jugadores WHERE procedencia = 'Serbia' ORDER BY equipo ASC, altura ASC;
+-----------------+--------+--------+
| nombre          | equipo | altura |
+-----------------+--------+--------+
| Dwayne Jones    |      7 |    210 |
| Marko Jaric     |     19 |    200 |
| Peja Stojakovic |     26 |    208 |
+-----------------+--------+--------+
3 rows in set (0.007 sec)

-- Ej3
mysql> SELECT nombre, equipo, posicion FROM jugadores WHERE salario > 100000 ORDER BY equipo ASC, posicion DESC;
+------------------+--------+----------+
| nombre           | equipo | posicion |
+------------------+--------+----------+
| Marcin Gortat    |      1 | F-C      |
| Louis Amundson   |      3 | F        |
| Calvin Booth     |      3 | C        |
| Darrel Armstrong |      4 | G        |
| Maurice Ager     |      4 | F-G      |
| Jerome James     |      5 | C        |
| LeBron James     |      7 | F        |
| Marquis Daniels  |      8 | G        |
| Charlie Bell     |     10 | G        |
| Carlos Arroyo    |     11 | G        |
| Brendan Haywood  |     12 | C        |
| Kevin Durant     |     20 | G        |
| Kobe Bryant      |     21 | G        |
| Luke Walton      |     21 | F        |
| Andrew Bynum     |     21 | C        |
| Shaquille ONeal  |     22 | C        |
| Monta Ellis      |     23 | G        |
| Al Harrington    |     23 | F-C      |
| Quinton Ross     |     25 | G-F      |
| Dan Dickau       |     25 | G        |
| Brent Barry      |     27 | G        |
| Rafer ALston     |     28 | G        |
| Andre Brown      |     30 | F        |
+------------------+--------+----------+
23 rows in set (0.007 sec)

-- Ej4
mysql> SELECT nombre, salario, salario * 0.82 AS neto FROM jugadores WHERE equipo = 19;
+-------------------+---------+-------------------+
| nombre            | salario | neto              |
+-------------------+---------+-------------------+
| Corey Brever      |   10000 |              8200 |
| Greg Buckner      |    9000 |              7380 |
| Michael Doleac    |   11000 |              9020 |
| Randy Foye        |   12000 |              9840 |
| Ryan Gomes        |    8000 |              6560 |
| Marko Jaric       |    8500 |              6970 |
| Al Jefferson      |    9000 |              7380 |
| Mark Madsen       |    9500 | 7789.999999999999 |
| Rashard McCants   |    9000 |              7380 |
| Chris Richard     |    8000 |              6560 |
| Craig Smith       |    9000 |              7380 |
| Kirk Snyder       |    8000 |              6560 |
| Sebastian Telfair |    8000 |              6560 |
| Antoine Walker    |    8500 |              6970 |
+-------------------+---------+-------------------+
14 rows in set (0.006 sec)

-- Ej5
mysql> SELECT CONCAT(nombre, ' - ', procedencia) AS jugaor FROM jugadores WHERE peso BETWEEN 80 AND 95 LIMIT 10;
+-----------------------------------+
| jugaor                            |
+-----------------------------------+
| Corey Brever - Florida            |
| Greg Buckner - Clemson            |
| Rashard McCants - North Carolina  |
| Dan Dickau - Gonzaga              |
| Shaun Livingston - Peoria Central |
| Smush Parker - Fordham            |
| Quinton Ross - Southern Methodist |
| Mike Conley - Ohio State          |
| Javaris Crittenton - Georgia Tech |
| Kyle Lowry - Villanova            |
+-----------------------------------+
10 rows in set (0.005 sec)

-- Ej6
mysql> SELECT * FROM jugadores WHERE equipo NOT IN (3,4,5,10) AND posicion = 'F' LIMIT 10;
+--------+--------------------+------------------+--------+------+----------+--------+---------+---------+
| codigo | nombre             | procedencia      | altura | peso | posicion | equipo | capitan | salario |
+--------+--------------------+------------------+--------+------+----------+--------+---------+---------+
|    244 | Glen Davis         | Louisiana State  |    205 |  114 | F        |      1 |     240 |   60000 |
|    245 | Kevin Garnett      | Farragut Academy |    210 |   99 | F        |      1 |     240 |   80000 |
|    248 | Paul Pierce        | Kansas           |    200 |  104 | F        |      1 |     240 |   80000 |
|    250 | James Posey        | Xavier           |    203 |   98 | F        |      1 |     240 |   80000 |
|    251 | Leon Powe          | California       |    203 |  108 | F        |      1 |     240 |   90000 |
|     88 | Jorge Garbajosa    | Spain            |    205 |  110 | F        |      2 |      82 |   42000 |
|     89 | Joey Graham        | Oklahoma State   |    200 |   98 | F        |      2 |      82 |   35000 |
|     90 | Kris Humphries     | Minnesota        |    205 |  105 | F        |      2 |      82 |   40000 |
|     91 | Linton Johnson III | Tulane           |    203 |  105 | F        |      2 |      82 |   30000 |
|     92 | Jason Kapono       | UCLA             |    203 |  110 | F        |      2 |      82 |   45000 |
+--------+--------------------+------------------+--------+------+----------+--------+---------+---------+
10 rows in set (0.007 sec)

-- Ej7
mysql> SELECT * FROM equipos WHERE division NOT IN ('East','West');
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
30 rows in set (0.017 sec)

-- Ej8
mysql> SELECT * FROM partidos WHERE temporada IN ('98/99','99/00') AND puntos_local < puntos_visitante AND arbitro = 13 LIMIT 10;
+--------+--------------+------------------+--------------+------------------+-----------+---------+
| codigo | equipo_local | equipo_visitante | puntos_local | puntos_visitante | temporada | arbitro |
+--------+--------------+------------------+--------------+------------------+-----------+---------+
|     13 |            2 |               10 |           66 |              118 | 98/99     |      13 |
|     75 |           30 |               14 |           57 |               84 | 98/99     |      13 |
|    137 |            5 |               18 |           56 |               63 | 98/99     |      13 |
|    168 |           19 |               23 |          131 |              148 | 98/99     |      13 |
|    292 |            7 |               21 |           68 |              136 | 98/99     |      13 |
|    332 |            8 |               10 |           73 |              158 | 98/99     |      13 |
|    364 |            9 |               13 |          134 |              153 | 98/99     |      13 |
|    426 |           11 |               17 |           53 |               77 | 98/99     |      13 |
|    458 |           12 |               23 |           85 |              150 | 98/99     |      13 |
|    651 |           20 |                9 |          151 |              152 | 98/99     |      13 |
+--------+--------------+------------------+--------------+------------------+-----------+---------+
10 rows in set (0.009 sec)

-- Ej9
mysql> SELECT * FROM jugadores WHERE nombre LIKE 'R%' AND procedencia = 'Slovenia';
+--------+------------------+-------------+--------+------+----------+--------+---------+---------+
| codigo | nombre           | procedencia | altura | peso | posicion | equipo | capitan | salario |
+--------+------------------+-------------+--------+------+----------+--------+---------+---------+
|     94 | Rasho Nesterovic | Slovenia    |    213 |  115 | C        |      2 |      82 |   60000 |
+--------+------------------+-------------+--------+------+----------+--------+---------+---------+
1 row in set (0.007 sec)

-- Ej10
mysql> SELECT * FROM jugadores WHERE LENGTH(nombre) > 10 LIMIT 10;
+--------+-----------------+----------------+--------+------+----------+--------+---------+---------+
| codigo | nombre          | procedencia    | altura | peso | posicion | equipo | capitan | salario |
+--------+-----------------+----------------+--------+------+----------+--------+---------+---------+
|      1 | Corey Brever    | Florida        |    205 |   83 | F-G      |     19 |    NULL |   10000 |
|      2 | Greg Buckner    | Clemson        |    193 |   95 | G-F      |     19 |       1 |    9000 |
|      3 | Michael Doleac  | Utah           |    210 |  118 | C        |     19 |       1 |   11000 |
|      6 | Marko Jaric     | Serbia         |    200 |  113 | G        |     19 |       1 |    8500 |
|      7 | Al Jefferson    | Prentiss Hs    |    208 |  120 | C-F      |     19 |       1 |    9000 |
|      8 | Mark Madsen     | Stanford       |    205 |  113 | C-F      |     19 |       1 |    9500 |
|      9 | Rashard McCants | North Carolina |    193 |   95 | G        |     19 |       1 |    9000 |
|     10 | Chris Richard   | Florida        |    205 |  122 | F        |     19 |       1 |    8000 |
|     11 | Craig Smith     | Boston College |    203 |  113 | F-C      |     19 |       1 |    9000 |
|     12 | Kirk Snyder     | Nevada-Reno    |    198 |  102 | G        |     19 |       1 |    8000 |
+--------+-----------------+----------------+--------+------+----------+--------+---------+---------+
10 rows in set (0.008 sec)

-- Ej11
mysql> SELECT nombre FROM jugadores WHERE posicion = 'C' AND salario > 100000;
+-----------------+
| nombre          |
+-----------------+
| Andrew Bynum    |
| Jerome James    |
| Calvin Booth    |
| Brendan Haywood |
| Shaquille ONeal |
+-----------------+
5 rows in set (0.008 sec)

-- Ej12
mysql> SELECT nombre FROM jugadores WHERE equipo IN (1,2) AND posicion = 'G';
+----------------+
| nombre         |
+----------------+
| Ray Allen      |
| Tony Allen     |
| Sam Cassell    |
| Eddie House    |
| Gabe Pruitt    |
| Rajon Rondo    |
| Jose Calderon  |
| Carlos Delfino |
| T.J. Ford      |
+----------------+
9 rows in set (0.006 sec)

-- Ej13
mysql> SELECT * FROM jugadores WHERE equipo = 3 ORDER BY salario;
+--------+------------------+-------------------+--------+------+----------+--------+---------+---------+
| codigo | nombre           | procedencia       | altura | peso | posicion | equipo | capitan | salario |
+--------+------------------+-------------------+--------+------+----------+--------+---------+---------+
|    122 | Rodney Carney    | Memphis           |    200 |  204 | F        |      3 |     120 |   12000 |
|    125 | Willie Green     | Detroit Mercy     |    190 |  100 | G        |      3 |     120 |   12000 |
|    131 | Jason Smith      | Colorado Sate     |    213 |  110 | F        |      3 |     120 |   12000 |
|    132 | Louis Williams   | South Gwinnett HS |    187 |   85 | G        |      3 |     120 |   12000 |
|    123 | Samuel Dalembert | Seton Hall        |    210 |  110 | C        |      3 |     120 |   22000 |
|    129 | Kevin Ollie      | Connecticut       |    187 |   82 | G        |      3 |     120 |   22000 |
|    133 | Thaddeus Young   | Georgio Tech      |    203 |  101 | F        |      3 |     120 |   22000 |
|    124 | Reggie Evans     | Iowa              |    203 |  108 | F        |      3 |     120 |   32000 |
|    126 | Herbert Hill     | Providence        |    208 |  110 | F-C      |      3 |     120 |   42000 |
|    130 | Shavlik Randolph | Duke              |    208 |  109 | F        |      3 |     120 |   42000 |
|    127 | Andre Iguodala   | Arizona           |    198 |   93 | F-G      |      3 |     120 |   52000 |
|    128 | Andre Miller     | Utah              |    187 |  289 | G        |      3 |     120 |   72000 |
|    120 | Louis Amundson   |  Nevada-Las Vegas |    203 |  105 | F        |      3 |    NULL |  115000 |
|    121 | Calvin Booth     | Penn State        |    210 |  113 | C        |      3 |     120 |  120000 |
+--------+------------------+-------------------+--------+------+----------+--------+---------+---------+
14 rows in set (0.007 sec)

-- Ej14
mysql> SELECT * FROM jugadores WHERE altura > 200 AND salario < 70000 LIMIT 10;
+--------+----------------+------------------+--------+------+----------+--------+---------+---------+
| codigo | nombre         | procedencia      | altura | peso | posicion | equipo | capitan | salario |
+--------+----------------+------------------+--------+------+----------+--------+---------+---------+
|      1 | Corey Brever   | Florida          |    205 |   83 | F-G      |     19 |    NULL |   10000 |
|      3 | Michael Doleac | Utah             |    210 |  118 | C        |     19 |       1 |   11000 |
|      7 | Al Jefferson   | Prentiss Hs      |    208 |  120 | C-F      |     19 |       1 |    9000 |
|      8 | Mark Madsen    | Stanford         |    205 |  113 | C-F      |     19 |       1 |    9500 |
|     10 | Chris Richard  | Florida          |    205 |  122 | F        |     19 |       1 |    8000 |
|     11 | Craig Smith    | Boston College   |    203 |  113 | F-C      |     19 |       1 |    9000 |
|     14 | Antoine Walker | Kentucky         |    205 |  111 | F        |     19 |       1 |    8500 |
|     21 | Elton Brand    | Duke             |    203 |  115 | F        |     25 |      23 |   10000 |
|     22 | Paul Davis     | Michigan         |    210 |  122 | C        |     25 |      23 |   10000 |
|     25 | Chris Kaman    | Central Michigan |    213 |  120 | C        |     25 |      23 |   10000 |
+--------+----------------+------------------+--------+------+----------+--------+---------+---------+
10 rows in set (0.005 sec)

-- Ej15
mysql> SELECT nombre FROM jugadores WHERE capitan IS NULL;
+---------------------+
| nombre              |
+---------------------+
| Corey Brever        |
| Dan Dickau          |
| Andre Brown         |
| Kobe Bryant         |
| Maceo Baston        |
| Jerome James        |
| Louis Amundson      |
| LeBron James        |
| Derek Anderson      |
| Charlie Bell        |
| Shannon Brown       |
| Ray Allen           |
| Mike Bibby          |
| Blake Ahearn        |
| Shareef Abdur-Rahim |
| Chris Andersen      |
| Rafer ALston        |
| Brent Barry         |
| LaMarcus Aldridge   |
| Gilbert Arenas      |
| Carlos Arroyo       |
| Malik Allen         |
| Maurice Ager        |
| Carmelo Anthony     |
| Morris Almond       |
| Marquis Daniels     |
| Arron Afflalo       |
| Kevin Durant        |
| Grant Hill          |
| Kelenna Azubuike    |
+---------------------+
30 rows in set (0.006 sec)

--Ej16
mysql> SELECT COUNT(*) AS Mayor2Metros FROM jugadores WHERE altura > 200;
+--------------+
| Mayor2Metros |
+--------------+
|          224 |
+--------------+
1 row in set (0.006 sec)

-- Ej17
mysql> SELECT AVG(salario) AS MediaSalario FROM jugadores;
+-------------------+
| MediaSalario      |
+-------------------+
| 69952.94965277778 |
+-------------------+
1 row in set (0.006 sec)

-- Ej18
mysql> SELECT MAX(salario) AS SalarioMaximo, MIN(salario) AS SalarioMin, MAX(salario)-MIN(salario) AS Diferencia FROM jugadores;
+---------------+------------+------------+
| SalarioMaximo | SalarioMin | Diferencia |
+---------------+------------+------------+
|        950000 |       1000 |     949000 |
+---------------+------------+------------+
1 row in set (0.009 sec)

-- Ej19
mysql> SELECT * FROM jugadores WHERE altura = (SELECT MAX(altura) FROM jugadores);
+--------+------------------+-------------+--------+------+----------+--------+---------+---------+
| codigo | nombre           | procedencia | altura | peso | posicion | equipo | capitan | salario |
+--------+------------------+-------------+--------+------+----------+--------+---------+---------+
|    350 | Dikembre Mutombo | Georgetown  |    225 |  125 | C        |     28 |     340 |   80000 |
+--------+------------------+-------------+--------+------+----------+--------+---------+---------+
1 row in set (0.038 sec)

-- Ej20
mysql> SELECT * FROM jugadores WHERE salario > (SELECT salario FROM jugadores WHERE nombre = 'Devin Brown') LIMIT 10;
+--------+-----------------+----------------------+--------+------+----------+--------+---------+---------+
| codigo | nombre          | procedencia          | altura | peso | posicion | equipo | capitan | salario |
+--------+-----------------+----------------------+--------+------+----------+--------+---------+---------+
|     23 | Dan Dickau      | Gonzaga              |    182 |   81 | G        |     25 |    NULL |  120000 |
|     24 | Nick Fazekas    | Nevada-Reno          |    210 |  106 | F        |     25 |      23 |   95000 |
|     32 | Quinton Ross    | Southern Methodist   |    198 |   87 | G-F      |     25 |      23 |  120000 |
|     41 | Andre Brown     | De Paul              |    205 |  115 | F        |     30 |    NULL |  180000 |
|     62 | Kobe Bryant     | Lower Merion HS (PA) |    198 |  103 | G        |     21 |    NULL |  180000 |
|     63 | Andrew Bynum    | St. Joseph HS (NJ)   |    213 |  110 | C        |     21 |      62 |  190000 |
|     65 | Derek Fisher    | Arkansas-Little Rock |    185 |   97 | G        |     21 |      62 |   90000 |
|     75 | Luke Walton     | Arizona              |    203 |  110 | F        |     21 |      62 |  150000 |
|    105 | Jerome James    | Florida AM           |    215 |   95 | C        |      5 |    NULL |  180000 |
|    110 | Randolph Morris | Kentucky             |    210 |  110 | C        |      5 |     105 |   95000 |
+--------+-----------------+----------------------+--------+------+----------+--------+---------+---------+
10 rows in set (0.010 sec)

-- Ej21
mysql> SELECT * FROM jugadores WHERE equipo = (SELECT id_equipo FROM equipos WHERE ciudad = 'Orlando');
+--------+-----------------+----------------------+--------+------+----------+--------+---------+---------+
| codigo | nombre          | procedencia          | altura | peso | posicion | equipo | capitan | salario |
+--------+-----------------+----------------------+--------+------+----------+--------+---------+---------+
|    420 | Carlos Arroyo   | Florida Internationa |    200 |  202 | G        |     11 |    NULL |  115000 |
|    421 | James Augustine | Illinois             |    208 |  106 | F        |     11 |     420 |   80000 |
|    422 | Tony Battie     | Texas Tech           |    210 |  108 | F-C      |     11 |     420 |   80000 |
|    423 | Keith Bogans    | Kentucky             |    195 |   97 | G-F      |     11 |     420 |   90000 |
|    424 | Brian Cook      | Illinois             |    205 |  113 | F        |     11 |     420 |   85000 |
|    425 | Kenyon Dooling  | Missouri             |    190 |   88 | G        |     11 |     420 |   80000 |
|    426 | Maurice Evans   | Texas                |    195 |  220 | G        |     11 |     420 |   70000 |
|    427 | Adonal Foyle    | Colgate              |    208 |  270 | C        |     11 |     420 |   60000 |
|    428 | Pat Garrity     | Notre Dame           |    205 |  238 | F        |     11 |     420 |   55000 |
|    430 | Dwight Howard   | SW Atlanta Crhistian |    210 |  120 | F-C      |     11 |     420 |   70000 |
|    431 | Rashard Lewis   | None                 |    208 |  104 | F        |     11 |     420 |   60000 |
|    432 | Jammer Nelson   | Saint Josephs        |    182 |   86 | G        |     11 |     420 |   50000 |
|    433 | J.J.Redick      | Duke                 |    193 |   86 | G        |     11 |     420 |   80000 |
|    434 | Hedo Turkoglu   | Turkey               |    208 |  220 | F        |     11 |     420 |   75000 |
+--------+-----------------+----------------------+--------+------+----------+--------+---------+---------+
14 rows in set (0.008 sec)

-- Ej22
mysql> SELECT nombre FROM jugadores WHERE salario = (SELECT MAX(salario) FROM jugadores) OR salario = (SELECT MIN(salario) FROM jugadores);
+-----------------+
| nombre          |
+-----------------+
| Brent Barry     |
| Austin Croshere |
+-----------------+
2 rows in set (0.008 sec)

-- Ej23
mysql> SELECT COUNT(*) AS DivisionCentral FROM jugadores WHERE equipo IN (SELECT id_equipo FROM equipos WHERE division = 'Central');
+-----------------+
| DivisionCentral |
+-----------------+
|              73 |
+-----------------+
1 row in set (0.010 sec)

-- Ej24
mysql> SELECT j.*, e.nombre, e.conferencia FROM jugadores j JOIN equipos e ON j.equipo = e.id_equipo WHERE e.conferencia = 'East' LIMIT 10;
+--------+------------------+-------------------+--------+------+----------+--------+---------+---------+---------+-------------+
| codigo | nombre           | procedencia       | altura | peso | posicion | equipo | capitan | salario | nombre  | conferencia |
+--------+------------------+-------------------+--------+------+----------+--------+---------+---------+---------+-------------+
|    240 | Ray Allen        | Connecticut       |    195 |  101 | G        |      1 |    NULL |  100000 | Celtics | East        |
|    241 | Tony Allen       | Oklahoma State    |    193 |  103 | G        |      1 |     240 |   80000 | Celtics | East        |
|    242 | P.J.Brown        | Louisiana State   |    210 |  107 | F-C      |      1 |     240 |   80000 | Celtics | East        |
|    243 | Sam Cassell      | Florida State     |    190 |   83 | G        |      1 |     240 |   70000 | Celtics | East        |
|    244 | Glen Davis       | Louisiana State   |    205 |  114 | F        |      1 |     240 |   60000 | Celtics | East        |
|    245 | Kevin Garnett    | Farragut Academy  |    210 |   99 | F        |      1 |     240 |   80000 | Celtics | East        |
|    246 | Eddie House      | Arizona State     |    185 |   80 | G        |      1 |     240 |   60000 | Celtics | East        |
|    247 | Kendrick Perkins | Clifton J.Ozen HS |    208 |  119 | C        |      1 |     240 |   70000 | Celtics | East        |
|    248 | Paul Pierce      | Kansas            |    200 |  104 | F        |      1 |     240 |   80000 | Celtics | East        |
|    249 | Scot Pollard     | Kansas            |    210 |  126 | C-F      |      1 |     240 |   80000 | Celtics | East        |
+--------+------------------+-------------------+--------+------+----------+--------+---------+---------+---------+-------------+
10 rows in set (0.008 sec)

-- Ej25

