package Servlets;

import Beans.bCarrera;
import Beans.bCurso;
import Beans.bDocente;
import Beans.bEstudiante;
import Beans.bSesion;
import Beans.bSesion_Estudiante;
import Datos.mCarrera;
import Datos.mCurso;
import Datos.mDocente;
import Datos.mEstudiante;
import Datos.mSesion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class controlador extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = null;
            HttpSession session = request.getSession();
            int opc = Integer.parseInt(request.getParameter("opc"));
            mDocente modelDocente = new mDocente();
            mCurso modelCurso = new mCurso();
            mCarrera modelCarrera = new mCarrera();
            mSesion modelSesion = new mSesion();
            switch (opc) {
                case 0:
                    response.sendRedirect("index.html");
                    break;
                case 1:
                    String user = request.getParameter("txtUser");
                    String pass = request.getParameter("txtPass");
                    List<bDocente> ds = modelDocente.login(user, pass);
                    if (ds.size() == 1) {
                        List<bCurso> cs = modelCurso.cursos_docente((ds.get(0)).getIddocente());
                        rd = request.getRequestDispatcher("home.jsp");
                        session.setAttribute("Docente", ds.get(0));
                        session.setAttribute("Cursos", cs.iterator());
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("controlador?opc=0");
                    }
                    break;
                case 2:
                    bDocente docente = (session.getAttribute("Docente") != null)
                            ? (bDocente) session.getAttribute("Docente") : null;
                    if (docente.equals(null)) {
                        response.sendRedirect("controlador?opc=0");
                    } else {
                        List<bCurso> cs = modelCurso.cursos_docente(docente.getIddocente());
                        rd = request.getRequestDispatcher("cursos.jsp");
                        session.setAttribute("Cursos", cs.iterator());
                        rd.forward(request, response);
                    }
                    break;
                case 21:
                    docente = (session.getAttribute("Docente") != null)
                            ? (bDocente) session.getAttribute("Docente") : null;
                    if (docente.equals(null)) {
                        response.sendRedirect("controlador?opc=0");
                    } else {
                        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                        List<bCurso> cs = modelCurso.sel_curso(idCurso);
                        if (cs.size() == 1) {
                            List<bCarrera> cs1 = modelCarrera.sel_carrera(cs.get(0).getCar_idcarrera());
                            List<bSesion> ses = modelSesion.sesiones(idCurso);
                            rd = request.getRequestDispatcher("curso.jsp");
                            session.setAttribute("Sesiones", ses.iterator());
                            session.setAttribute("CursoSel", (bCurso) cs.get(0));
                            session.setAttribute("Carrera", cs1.get(0));
                            rd.forward(request, response);
                        } else {
                            response.sendRedirect("controlador?opc=2");
                        }
                    }
                    break;
                case 211:
                    docente = (session.getAttribute("Docente") != null)
                            ? (bDocente) session.getAttribute("Docente") : null;
                    if (docente.equals(null)) {
                        response.sendRedirect("controlador?opc=0");
                    } else if (session.getAttribute("Carrera") != null
                            && session.getAttribute("CursoSel") != null
                            && session.getAttribute("Sesiones") != null) {
                        rd = request.getRequestDispatcher("alumnos.jsp");
                        bCurso curso = (bCurso) request.getSession().getAttribute("CursoSel");
                        mEstudiante me = new mEstudiante();
                        List<bEstudiante> lista = me.listar(curso.getIdcurso());
                        session.setAttribute("Estudiantes", lista.iterator());
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("controlador?opc=1");
                    }
                    break;
                case 3:
                    docente = (session.getAttribute("Docente") != null)
                            ? (bDocente) session.getAttribute("Docente") : null;
                    if (docente.equals(null)) {
                        response.sendRedirect("controlador?opc=0");
                    } else {
                        String codigoEstudiante = request.getParameter("codigo");
                        if (!codigoEstudiante.equals(null)) {
                            rd = request.getRequestDispatcher("alumno.jsp");
                            int estudiante_codigo = Integer.parseInt(request.getParameter("codigo"));
                            mSesion ms = new mSesion();
                            mEstudiante me = new mEstudiante();
                            List<bEstudiante> es = me.listarE(request.getParameter("codigo"));
                            List<bSesion_Estudiante> estados = ms.estados(estudiante_codigo);
                            session.setAttribute("Estados", estados.iterator());
                            session.setAttribute("EstudianteSel", (bEstudiante) es.get(0));
                            rd.forward(request, response);
                        } else {
                            response.sendRedirect("controlador?opc=1");
                        }
                    }
                    break;
                case 7:
                    docente = (session.getAttribute("Docente") != null)
                            ? (bDocente) session.getAttribute("Docente") : null;
                    if (docente.equals(null)) {
                        response.sendRedirect("controlador?opc=0");
                    } else {
                        rd = request.getRequestDispatcher("generador.jsp");
                        rd.forward(request, response);
                    }
                    break;
                default:
                    out.print("<h1>[Default] Controlador</h1>\n"
                            + "<h2>../controlador?opc=" + opc + "</h2>"
                            + "<p>Error en controlador, no se ha encontrado "
                            + "la opción ingresada :(</p>\n"
                            + "<a href=\"controlador?opc=0\">Ir al Inicio</a>\n");
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
