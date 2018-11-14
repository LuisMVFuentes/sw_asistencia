<%-- 
    Document   : config
    Created on : 14/11/2018, 03:58:19 PM
    Author     : manue
--%>
<%@page import="Beans.bCurso"%>
<%@page import="java.util.Iterator"%>
<%@page import="Beans.bDocente"%>
<%
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
    } else {
        
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
        <title>Configuracion</title>
    </head>
    <body>
        <header>
            <!--Navbar-->
            <nav class="black" role="navigation">
                <div class="nav-wrapper container">
                    <a id="logo-container" href="controlador?opc=99" class="brand-logo teal-text text-lighten-2">SW Asistencia</a>
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
                <div class="section">
                    <h3 class="center-align">Configuracion</h3>
                </div>
                <div class="divider"></div>
                <form action="controlador">
                    <div class="section">
                        <table class="striped responsive-table">
                            <tr>
                                <th>Nombre</th>
                                <td><input readonly="" type="text" name="txtNombre" value="<%=docente.getNombre_doc()%>"></td>
                            </tr>
                            <tr>
                                <th>Id</th>
                                <td><input readonly="" type="text" name="txtIdDocente" value="<%=docente.getIddocente()%>"></td>
                            </tr>
                            <tr>
                                <th>Codigo</th>
                                <td><input type="text" name="txtCodigo" value="<%=docente.getCodigo()%>"></td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td><input type="email" name="txtCorreo" value="<%=docente.getCorreo()%>"</td>
                            </tr>
                            <tr>
                                <th>Password</th>
                                <td><input type="password" id="input_text" name="txtPassword" value="<%=docente.getPassword()%>" data-length="8"</td>
                            </tr>
                        </table>
                    </div>
                    <div class="divider"></div>
                    <div class="section center-align">
                        <input type="hidden" name="opc" value="4"><input class="waves-effect waves-green btn-flat" type="submit" value="Guardar">
                        <a href="controlador?opc=99" class="modal-close waves-effect waves-green btn-flat">Cancelar</a>
                    </div>
                </form>
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
