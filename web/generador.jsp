<%-- 
    Document   : generador
    Created on : 13/11/2018, 04:09:11 PM
    Author     : manue
--%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="reporteDocente.jsp">Reporte</a>
    </body>
</html>
