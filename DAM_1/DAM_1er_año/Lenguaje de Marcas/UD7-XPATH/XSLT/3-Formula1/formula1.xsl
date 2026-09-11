<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    
    <xsl:output method="html" indent="yes"/>
    
    
    <xsl:template match="/*">
        <html lang="es">
            <head>
                <meta charset="UTF-8" />
                <title>Clasificación de Fórmula 1</title>
                <link rel="stylesheet" href="estilos.css" />
            </head>
            <body>
                <div class="header">
                    <h1>Clasificación de Fórmula 1</h1>
                </div>
                
                <main>
                    <h2>Listado de Equipos y Coches</h2>
                    <table class="formula1-t ancho">
                        <thead>
                            <tr>
                                <th>Equipo</th>
                                <th>Modelo</th>
                                <th>Piloto</th>
                                <th>Puntos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Lista de equipos y coches generada por XSLT -->  
                            <xsl:for-each select="//coche">
                                <xsl:variable name="modelo" select="@modelo"/>
                                <tr>
                                    <td> <xsl:value-of select="//equipo/coche[@modelo=$modelo]/../@nombre" /></td>
                                    <td> <xsl:value-of select="@modelo" /></td>
                                    <td> <xsl:value-of select="@piloto" /></td>
                                    <td> <xsl:value-of select="@puntos" /></td>
                                </tr>
                                
                            </xsl:for-each>
                        </tbody>
                    </table>
                    
                    <h2>Clasificación General</h2>
                    <table class="formula1-t ancho">
                        <thead>
                            <tr>
                                <th>Posición</th>
                                <th>Piloto</th>
                                <th>Equipo</th>
                                <th>Puntos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Clasificación general generada por XSLT -->
                            <xsl:for-each select="//coche">
                            <xsl:variable name="modelo" select="@modelo"/>
                                <xsl:if test="position()&lt;=10">
                                    <tr>
                                        <td> <xsl:value-of select="position()" /></td>
                                        <td> <xsl:value-of select="@piloto" /></td>
                                        <td> <xsl:value-of select="//equipo/coche[@modelo=$modelo]/../@nombre" /></td>
                                        <td> <xsl:value-of select="@puntos" /></td>
                                    </tr>
                                </xsl:if>
                                
                                
                            </xsl:for-each>
                        </tbody>
                    </table>
                    <!-- Estadísticas -->
                    <div class="estad">
                        <h2>Estadísticas</h2>
                        <ul>
                            <li><span>Número total de equipos:</span> <span class="stats"><!-- Inserta aquí el número total de equipos --></span></li>
                            <li><span>Número total de coches:</span> <span class="stats"><!-- Inserta aquí el número total de coches --></span></li>
                            <li><span>Puntuación media:</span> <span class="stats"><!-- Inserta aquí la puntuación media --></span></li>
                        </ul>
                        
                        <!-- Tabla de participantes por provincia -->
                        <table class="participantes-t">
                            <thead>
                                <tr>
                                    <th>Provincia</th>
                                    <th>Nº Equipos</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Tabla de participantes por provincia generada por XSLT -->
                                <!-- Inserta aquí el HTML resultante después de aplicar la transformación XSLT -->
                            </tbody>
                        </table>
                    </div>
                </main>
                <footer>
                    <p>Nombre del Alumno - 2024</p>
                </footer>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>