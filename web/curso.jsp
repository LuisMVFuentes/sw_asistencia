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
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2><%=curso.toString()%></h2>
        <h2><%=carrera.toString()%></h2>
        <%
            int cont = 0;
            for (Iterator it = itSesiones; it.hasNext();) {
                bSesion sesion = (bSesion) it.next();
        %>
        <h2><%=sesion.toString()%><a href="controlador?opc=211">Ver Alumnos</a></h2>
        <%
                cont++;
            }
            if (cont == 0) {
        %>
        <h2>No hay sesiones.</h2>
        <%
            }
        %>
    </body>
</html>
