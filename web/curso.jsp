<%@page import="Beans.bSesion"%>
<%@page import="Beans.bCarrera"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.bDocente"%>
<%@page import="Beans.bCurso"%>
<%
    bCarrera carrera = new bCarrera();
    bCurso curso = new bCurso();
    Iterator<bSesion> itSesiones = (new ArrayList<bSesion>()).iterator();
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
    } else {
        curso = (session.getAttribute("CursoSel") != null)
                ? (bCurso) session.getAttribute("CursoSel") : curso;
        carrera = (session.getAttribute("Carrera") != null)
                ? (bCarrera) session.getAttribute("Carrera") : carrera;
        itSesiones = (session.getAttribute("Sesiones") != null)
                ? (Iterator<bSesion>) session.getAttribute("Sesiones") : itSesiones;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="images/savings.png" rel="shortcut icon">
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <script src="js/script.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <!--Navbar-->
        <nav class="black" role="navigation">
            <div class="nav-wrapper container">
                <a id="logo-container" href="controlador?opc=0" class="brand-logo teal-text text-lighten-2">SW Asistencia</a>
                <div class="row">
                    <ul class="right hide-on-med-and-down">
                        <!--items-->
                    </ul>
                </div>
            </div>
        </nav>
        <h2><%=curso.toString()%></h2>
        <h2><%=carrera.toString()%></h2>
        <%
            int cont = 0;
            for (Iterator it = itSesiones; it.hasNext();) {
                bSesion sesion = (bSesion) it.next();
        %>
        <h4><%=sesion.toString()%><a href="controlador?opc=211">Ver Alumnos</a></h4>
        <%
                cont++;
            }
            if (cont == 0) {
        %>
        <h2>No hay sesiones.</h2>
        <%
            }
        %>
         <!--Footer -->
        <footer class="page-footer black">
            <div class="footer-copyright white-text">
                <div class="container">
                    Made by <a class="white-text" href="http://materializecss.com">Materialize</a>
                </div>
            </div>
        </footer>
        <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/init.js"></script>
    </body>
</html>
