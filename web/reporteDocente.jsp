<%-- 
    Document   : reporteDocente
    Created on : 13/11/2018, 04:27:09 PM
    Author     : manue
--%>

<%@page import="java.util.Map"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="java.io.File"%>
<%@page import="Datos.CADO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CADO cado = new CADO();
            String ruta = System.getProperty("catalina.home") + "\\webapps\\sw_asistencia\\reports\\prueba.jasper";
            File archivo = new File(ruta);
            Map<String, Object> param = new HashMap<String, Object>();
            byte[] bytes = JasperRunManager.runReportToPdf(archivo.getPath(), param, cado.conectar());
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream salida = response.getOutputStream();
            salida.write(bytes, 0, bytes.length);
            salida.flush();
            salida.close();
        %>
    </body>
</html>
