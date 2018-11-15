<%-- 
    Document   : addCurso
    Created on : 14/11/2018, 07:54:24 PM
    Author     : manue
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Beans.bCarrera"%>
<%@page import="Utiles.random"%>
<%@page import="Beans.bDocente"%>
<%@page import="Beans.bCurso"%>
<%
    Iterator<bCarrera> carreras = null;
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
    } else {
        carreras = (session.getAttribute("Carreras") != null)
                ? (Iterator<bCarrera>) session.getAttribute("Carreras") : null;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Curso</title>
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
                    <a id="logo-container" href="#!" class="brand-logo teal-text text-lighten-2">SW Asistencia</a>
                    <ul class="left">
                        <li href="#" data-target="slide-out" class="sidenav-trigger btn teal white-text"><i class="material-icons">menu</i></a></li>
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
        </header>
        <main>
            <div class="container z-depth-3">
                <div class="container row">
                    <h3 class="center teal-text">Nuevo Curso</h3>
                </div>
                <div class="divider"></div>
                <div class="container">
                    <form action="controlador">
                        <table class="responsive-table">
                            <tr>
                                <th>Codigo:</th>
                                <td><input type="text" id="input_text" name="txtCodigo" data-length="5"></td>
                            </tr>
                            <tr>
                                <th>Nombre:</th>
                                <td><input type="text" name="txtNombre"></td>
                            </tr>
                            <tr>
                                <th>Grupo:</th>
                                <td><input type="text"  name="txtGrupo"></td>
                            </tr>
                            <tr>
                                <th>Ciclo</th>
                                <td><div class="input-field col s6">
                                        <select name="txtCiclo" class="browser-default">
                                            <option value="" disabled selected>-- Selecciona Ciclo --</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <th>Carrera:</th>
                                <td><div class="input-field col s6">
                                        <select name="txtCarrera" class="browser-default">
                                            <option value="" disabled selected>-- Selecciona Carrera --</option>
                                            <%
                                                for (Iterator it = carreras; it.hasNext();) {
                                                    bCarrera carrera = (bCarrera) it.next();
                                            %>
                                            <option value="<%=carrera.getIdcarrera()%>"><%=carrera.getCarrera()%></option>
                                            <%
                                                }
                                            %>         
                                        </select>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <div class="divider"></div>
                        <div class="section">
                            <input type="hidden" name="opc" value="51"><input class="waves-effect waves-green btn-flat" type="submit" value="Agregar">
                            <a href="controlador?opc=99" class="modal-close waves-effect waves-green btn-flat">Cancelar</a>
                        </div>
                    </form>
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
