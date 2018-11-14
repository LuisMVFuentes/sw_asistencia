<%@page import="Beans.bDocente"%>
<%
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
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
                <div class="row">
                    <ul class="right hide-on-med-and-down">
                        <!--items-->
                    </ul>
                </div>
            </div>
        </nav>
        <main>
        <div id="index-banner" class="parallax-container">
            <div class="section no-pad-bot">
                <div class="container">
                    <br><br>
                    <h1 class="header center teal-text text-lighten-2">SW Asistencia</h1>
                    <div class="row center">
                        <h5 class="header col s12 light">Bienvenido <%=docente.toString()%></h5>
                        <a href="controlador?opc=2">Cursos</a>
                        <br>
                        <a href="controlador?opc=7">Reporte</a>
                    </div>
                    <!--<div class="row center">
                        <a href="#" id="download-button" class="btn-large waves-effect waves-light teal lighten-1">Get Started</a>
                    </div>-->
                    <br><br>

                </div>
            </div>
            <div class="parallax"><img src="images/background2.jpg"></div>
        </div>

        <div class="parallax-container valign-wrapper">
            <div class="parallax"><img src="images/background4.jpg"></div>
        </div>

        <div class="parallax-container valign-wrapper">
            <div class="parallax"><img src="images/background5.jpg"></div>
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
