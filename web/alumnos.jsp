<%@page import="Beans.bEstudiante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Beans.bDocente"%>
<%
    Iterator<bEstudiante> itEstudiantes = (new ArrayList<bEstudiante>()).iterator();
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (session.getAttribute("Docente") == null) {
        response.sendRedirect("controlador?opc=0");
    } else {
        itEstudiantes = (session.getAttribute("Estudiantes") != null)
                ? (Iterator<bEstudiante>) session.getAttribute("Estudiantes") : itEstudiantes;
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
        <title>Alumnos</title>
    </head>
    <body>
        <header>
            <!--Navbar-->
            <nav class="black" role="navigation">
                <div class="nav-wrapper container">
                    <ul class="left">
                        <li href="#" data-target="slide-out" class="sidenav-trigger btn teal white-text"><i class="material-icons">menu</i></a></li>
                        </li>
                    </ul>
                    <a id="logo-container" href="#!" class="brand-logo teal-text text-lighten-2">SW Asistencia</a>
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
        </header>
        <main>
            <div class="container row">
                <div class="col l3">
                    <ul class="collapsible z-depth-3">
                        <li class="collapsible-header"> 
                            <a href="controlador?opc=2" class="teal-text text-lighten-2"><i class="material-icons">folder</i> <b>Cursos</b></a>
                        </li>
                        <li class="collapsible-header">
                            <a href="controlador?opc=7" class="teal-text text-lighten-2"><i class="material-icons">folder</i> <b>Reporte</b></a>
                        </li>
                    </ul>
                </div>
                <div class="col l9">
                    <div class="card-panel z-depth-3">
                        <h4 class="center teal-text">Lista de Estudiantes en el Curso</h4>
                        <div class="section left-align">
                            <a href="controlador?opc=#!" class="waves-effect waves-green btn-flat"><i class="material-icons left">add</i>Agregar</a>
                            <a href="controlador?opc=#!" class="waves-effect waves-green btn-flat" target="_blank"><i class="material-icons left">insert_drive_file</i>Reporte</a>
                        </div>
                        <ul class="collapsible popout">
                            <%
                                for (Iterator it = itEstudiantes; it.hasNext();) {
                                    bEstudiante estudiante = (bEstudiante) it.next();
                            %>
                            <li>
                                <div class="collapsible-header"><i class="material-icons">person</i><%=estudiante.getNombre()%></div>
                                <div class="collapsible-body"><%=estudiante.toString()%><span>
                                        <br><a href="controlador?opc=3&codigo=<%=estudiante.getCodigo()%>">Ver más</a>
                                    </span></div>
                            </li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </div>
            </div>
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
