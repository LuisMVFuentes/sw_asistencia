<%@page import="Beans.bEstudiante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Beans.bDocente"%>
<%
    Iterator<bEstudiante> itEstudiantes = (new ArrayList<bEstudiante>()).iterator();
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
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
        <title>Alumnos</title>
    </head>
    <body>
        <h2>Lista de Estudiantes en el Curso: </h2>
        <ul>
            
            <%
                for (Iterator it = itEstudiantes; it.hasNext();) {
                        bEstudiante estudiante = (bEstudiante)it.next();
                        %>
                        <li><%=estudiante.getCodigo()+" - "+estudiante.getNombre()+" - "+estudiante.getCorreo()+" - "+ estudiante.getCelular()%><a href="alumno.jsp">Ver más</a></li>
            <% 
                    }
            %>
        </ul>
    </body>
</html>
