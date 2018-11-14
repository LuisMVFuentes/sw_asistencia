<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Beans.bCurso"%>
<%@page import="Beans.bDocente"%>
<%
    Iterator<bCurso> itCursos = (new ArrayList<bCurso>()).iterator();
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
    } else {
        itCursos = (session.getAttribute("Cursos") != null)
                ? (Iterator<bCurso>) session.getAttribute("Cursos") : itCursos;
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
        <ul>
            <%int cont = 0;
                for (Iterator it = itCursos; it.hasNext();) {
                    bCurso curso = (bCurso) it.next();
            %>
            <li><%=curso.getCodigo() + " - " + curso.getNombre() + " - " + curso.getGrupo()%><a href="controlador?opc=21&idCurso=<%=curso.getIdcurso()%>">Ver más</a></li>
                <%
                        cont++;
                    }
                    if (cont == 0) {
                %>
            <li>No hay Cursos</li>
                <%
                    }
                %>

        </ul>
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
