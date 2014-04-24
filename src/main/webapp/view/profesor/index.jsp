<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Listado de Profesores">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="listarProfesores">
        <fieldset>
            <legend>Datos de B&uacute;squeda</legend>
            <div>
                <label for="nombres">
                    Nombres
                </label>
                <input type="search" name="nombres" id="nombres" maxlength="50" />
            </div>
            <div>
                <label for="apellidoPaterno">
                    Apellido Paterno
                </label>
                <input type="search" name="apellidoPaterno" id="apellidoPaterno" maxlength="50" />
            </div>
            <div>
                <label for="apellidoMaterno">
                    Apellido Materno
                </label>
                <input type="search" name="apellidoMaterno" id="apellidoMaterno" maxlength="50" />
            </div>
        </fieldset>
        <button><span>Buscar</span></button>
    </form>
    <div>
        <nav>
            <ul>
                <li>
                    <a href="irRegistroProfesor">
                        Registrar nuevo profesor
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <c:forEach var="profesor" items="${requestScope.profesores}" >
                <li>
                    <span>${profesor.codigo}</span>
                    <span>${profesor.nombres} ${profesor.apellidoPaterno} ${profesor.apellidoMaterno}</span>
                    <span>${profesor.email1}</span>
                    <span>${profesor.sexo}</span>
                </li>
            </c:forEach>
        </ul>
    </div>
</gch:base>