<%@tag description="Contiene la base del HTML para las paginas GCH"
       pageEncoding="UTF-8" %>
<%@attribute name="titulo"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <%@include file="/WEB-INF/jspf/headbasico.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/cabecera.jspf" %>
        <%@include file="/WEB-INF/jspf/ayuda.jspf" %>
        <section id="contenido">
            <h1>${titulo}</h1>
            <div>
                <jsp:doBody />
            </div>
        </section>
        <%@include file="/WEB-INF/jspf/piepagina.jspf" %>
    </body>
</html>
