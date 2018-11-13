package Servlets;

import Beans.bDocente;
import Datos.mDocente;
import java.io.IOException;
import java.io.PrintWriter;
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
            switch (opc) {
                case 0:
                    response.sendRedirect("index.html");
                    break;
                case 1:
                    String user = request.getParameter("txtUser");
                    String pass = request.getParameter("txtPass");
                    List<bDocente> ds = modelDocente.login(user, pass);
                    if (ds.size() == 1) {
                        rd = request.getRequestDispatcher("home.jsp");
                        session.setAttribute("Docente", ds.get(0));
                        rd.forward(request, response);
                    } else {
                        response.sendRedirect("controlador?opc=0");
                    }
                    break;
                default:
                    out.print("        <h1>[Default] Controlador</h1>\n"
                            + "        <h2>../controlador?opc=" + opc + "</h2>"
                            + "        <p>Error en controlador, no se ha encontrado la opción ingresada :(</p>\n"
                            + "        <a href=\"controlador?opc=0\">Ir al Inicio</a>\n"
                            + "");
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
