<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Saludo desde Archivo xml</h2>
                <p><xsl:value-of select="/mensaje/saludo"/></p>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
