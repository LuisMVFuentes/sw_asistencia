<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.bDocente"%>
<%@page import="Beans.bCurso"%>

<%
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    Iterator<bCurso> itCursos = (new ArrayList<bCurso>()).iterator();
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
        <title>SW Asistencia</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="images/savings.png" rel="shortcut icon">
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet">
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <script src="js/script.js"></script>
    </head>
    <body>
        <!--Navbar-->
        <nav class="black" role="navigation">
            <div class="nav-wrapper container">
                <a id="logo-container" href="controlador?opc=0" class="brand-logo teal-text text-lighten-2">SW Asistencia</a>
                <ul class="left">
                    <li href="#" data-target="slide-out" class="sidenav-trigger btn blue-grey white-text"><i class="material-icons">menu</i></a></li>
                    </li>
                </ul>
            </div>
        </nav>
        <ul id="slide-out" class="sidenav">
            <li><div class="user-view">
                    <div class="background">
                        <img src="images/background1.jpg">
                    </div>
                    <a href="#user"><img width="100px" height="100px" src="images/savings.png"></a>
                    <a href="#name"><span class="white-text name">
                            <%=docente.getNombre_doc()%>
                        </span></a>
                    <a href="#name"><span class="white-text name">
                            <%=docente.getCodigo()%></span></a>
                    <a href="#email"><span class="white-text email"><%=docente.getCorreo()%></span></a>
                </div></li>
            <li><a href="controlador?opc=31"><i class="material-icons">settings</i>Configuración</a></li>
            <li><div class="divider"></div></li>
            <li><a class="subheader">Sesion</a></li>
            <li><a class="waves-effect" href="controlador?opc=22">Cerrar Sesion</a></li>
        </ul>


        <div class="container row">
            <div class="col l5">
                <ul class="collapsible z-depth-3">
                    <li class="collapsible-header"> 
                        <a href="controlador?opc=2" class="teal-text text-lighten-2"><i class="material-icons">folder</i> <b>Cursos</b></a>
                    </li>
                    <li class="collapsible-header">
                        <a href="controlador?opc=7" class="teal-text text-lighten-2"><i class="material-icons">folder</i> <b>Reporte</b></a>
                    </li>
                </ul>
            </div>
            <div class="col l7">
                <div class="card-panel z-depth-3">

                </div>
            </div>
        </div>

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
