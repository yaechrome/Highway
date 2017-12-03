package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.EncargadoDaoImp;
import dto.EncargadoDto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.ConstanteUtil;
import static util.ConstanteUtil.*;

/**
 *
 * @author nippo
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

     private void iniciarSesion(EncargadoDto encargado, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(ConstanteUtil.LOGIN_USUARIO, encargado);
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.getRequestDispatcher(LOGIN_URL_FILE).forward(request, response);
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
        String mensajeError = "default message";
            boolean error = false;
            String nombreLogin = request.getParameter("user").trim();
            String pass = request.getParameter("pass").trim();
            if (!new EncargadoDaoImp().ValidarLogin(nombreLogin)) {
                mensajeError = "Usuario no existe";
                error = true;
            }

            if (!new EncargadoDaoImp().ValidarPassword(nombreLogin, new EncargadoDaoImp().Encriptar(pass))) {
                mensajeError = "Clave incorrecta";
                error = true;
            }

            if (!error) {
                iniciarSesion(new EncargadoDaoImp().BuscarUsuario(nombreLogin), request);
                response.sendRedirect(request.getContextPath() + INDEX_URL_FILE);
            } else {
                request.setAttribute("mensajeError", mensajeError);
                request.getRequestDispatcher(ConstanteUtil.LOGIN_URL_FILE).forward(request, response);
            }
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
