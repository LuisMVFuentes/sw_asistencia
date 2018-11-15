<%-- 
    Document   : alumno
    Created on : 13/11/2018, 11:29:17 PM
    Author     : manue
--%>
<%@page import="Beans.bEstudiante"%>
<%@page import="Beans.bDocente"%>
<%@page import="Beans.bSesion_Estudiante"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%
    Iterator<bSesion_Estudiante> itEstados = (new ArrayList<bSesion_Estudiante>()).iterator();
    bEstudiante estudiante = null;
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (session.getAttribute("Docente") == null) {
        response.sendRedirect("controlador?opc=0");
    } else {
        itEstados = (session.getAttribute("Estados") != null)
                ? (Iterator<bSesion_Estudiante>) session.getAttribute("Estados") : itEstados;
        estudiante = (session.getAttribute("EstudianteSel") != null)
                ? (bEstudiante) session.getAttribute("EstudianteSel") : estudiante;
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
        <header>
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
        </header>
        <main>
            <h3>Alumno:</h3>
            <h5><%=estudiante.toString()%></h5>
            <br>
            <h3>Estados</h3>
            <ul>
                <%
                    for (Iterator it = itEstados; it.hasNext();) {
                        bSesion_Estudiante estado = (bSesion_Estudiante) it.next();
                %>
                <li><%=estado.toString()%></li>
                    <%
                        }
                    %>
            </ul>
        </main>
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
