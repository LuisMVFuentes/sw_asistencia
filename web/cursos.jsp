<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="Beans.bCurso"%>
<%@page import="Beans.bDocente"%>
<%
    Iterator<bCurso> itCursos = (new ArrayList<bCurso>()).iterator();
    bDocente docente = (session.getAttribute("Docente") != null)
            ? (bDocente) session.getAttribute("Docente") : null;
    if (docente.equals(null)) {
        response.sendRedirect("controlador?opc=0");
    } else {
        itCursos = (session.getAttribute("Cursos") != null)
                ? (Iterator<bCurso>) session.getAttribute("Cursos") : itCursos;
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
        <ul>
            <%int cont = 0;
                for (Iterator it = itCursos; it.hasNext();) {
                    bCurso curso = (bCurso) it.next();
            %>
            <li><%=curso.getCodigo() + " - " + curso.getNombre() + " - " + curso.getGrupo()%><a href="controlador?opc=21&idCurso=<%=curso.getIdcurso()%>">Ver más</a></li>
                <%
                        cont++;
                    }
                    if (cont == 0) {
                %>
            <li>No hay Cursos</li>
                <%
                    }
                %>

        </ul>
    </body>
</html>
