<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
                <title>
                    <xsl:value-of select="empresa/@nombre"/>
                </title>
                <link rel="stylesheet" href="../CSS/estilos.css" />
            </head>
            
            <body>
                <div class="info">Datos del primer primer empleado</div>
                <table>
                    <caption>El Corte Inglés</caption>
                    <tbody>
                        <tr>
                            <th>Nombre</th>
                            <th>Trabajo</th>
                            <th>Sueldo</th>
                        </tr>
                        
                        <!-- Recorro todos los empleados -->
                        <xsl:for-each select="empresa/departamento/empleado">
                            <!-- Ordeno todos los empleados descendientemente por nombre -->
                            <xsl:sort select="nombre" order="descending" />
                                <tr>
                                <!-- Si el sueldo es mayor de 2700, pongo la clase gt-2700 al tr
                                si no, pongo la clase lt-2700 al tr -->
                                <xsl:choose>
                                    <xsl:when test="sueldo &gt; 2700">
                                        <xsl:attribute name="class">gt-2700</xsl:attribute>
                                    </xsl:when>
                                    <xsl:when test="sueldo &lt; 2700">
                                        <xsl:attribute name="class">lt-2700</xsl:attribute>
                                    </xsl:when>
                                </xsl:choose>
                                    <td>
                                    <xsl:if test="@nacionalidad">
                                        <span class="nationality">
                                            <xsl:value-of select="@nacionalidad"/>
                                        </span>
                                    </xsl:if>
                                        <xsl:value-of select="nombre"/>
                                    </td>
                                    <td>
                                        <xsl:value-of select="trabajo"/>
                                    </td>
                                    <td class="number">
                                        <xsl:value-of select="format-number(sueldo, '#.00')"/>
                                    </td>
                                </tr>
     
                        </xsl:for-each>
                        
                        
                        <!-- Fin Recorro -->
                        
                        <tr>
                            <td colspan="2">TOTAL DE SUELDOS</td>
                            <td class="number">
                                <xsl:value-of select="format-number(sum(empresa/departamento/empleado/sueldo),'#.00')"/>
                            </td>
                        </tr>
                    </tbody>
                </table>
                
            </body>
            
            
        </html>
    </xsl:template>
    
    
    
</xsl:stylesheet>