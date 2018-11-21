<%@page import="Utiles.Fecha"%>
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
            ? (bDocente) session.getAttribute("Docente") : new bDocente();
    if (session.getAttribute("Docente") == null) {
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
        <header>
            <!--Navbar-->
            <nav class="black" role="navigation">
                <div class="nav-wrapper container">
                    <ul class="left">
                        <li href="#" data-target="slide-out" class="sidenav-trigger btn teal white-text"><i class="material-icons">menu</i></a></li>
                        </li>
                    </ul>
                    <a id="logo-container" href="controlador?opc=99" class="brand-logo teal-text text-lighten-2">SW Asistencia</a>
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
                        <h4 class="center teal-text"><%=curso.getNombre()%></h4>
                        <div class="center-align">
                            <div class="chip"><b>Codigo: </b><%=curso.getCodigo()%></div>
                            <div class="chip"><b>Carrera: </b><%=carrera.getCarrera()%></div>
                            <div class="chip"><b>Facultad: </b><%=carrera.getFacultad()%></div>
                            <div class="chip"><b>Grupo: </b><%=curso.getGrupo()%></div>
                        </div>
                        <%
                            int cont = 0;
                            for (Iterator it = itSesiones; it.hasNext();) {
                                bSesion sesion = (bSesion) it.next();
                        %>
                        <div class="card teal">
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4"><b>Sesion N° <%=sesion.getIdsesiones()%>: </b><%=sesion.getFecha()%>
                                    <%if (sesion.getFecha().equals(new Fecha().getFecha("-"))) {%><i class="material-icons left">fiber_new</i><%}%>
                                    <i class="material-icons right">more_vert</i></span>
                                <p><a class="white-text" href="controlador?opc=211">Ver Alumnos</a></p>
                            </div>
                        </div>
                        <%
                                cont++;
                            }
                            if (cont == 0) {
                        %>
                        <div class="card white">
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4">No hay sesiones.<i class="material-icons right">more_vert</i></span>
                                <p><a class="white-text" href="controlador?opc=211">Ver Alumnos</a></p>
                            </div>
                        </div>
                        <%
                            }
                        %>
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
