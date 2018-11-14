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
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
    } else {
        itEstados = (session.getAttribute("Estados") != null)
                ? (Iterator<bSesion_Estudiante>) session.getAttribute("Estados") : itEstados;
        estudiante = (session.getAttribute("EstudianteSel")!=null)
                ? (bEstudiante)session.getAttribute("EstudianteSel"): estudiante;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alumno:</h1>
        <h2><%=estudiante.toString()%></h2>
        <ul>
            <%
                for (Iterator it = itEstados; it.hasNext();) {
                        bSesion_Estudiante estado = (bSesion_Estudiante)it.next();
                        %>
                        <li><%=estado.toString()%></li>
            <%                        
                    }
            %>
        </ul>
    </body>
</html>
