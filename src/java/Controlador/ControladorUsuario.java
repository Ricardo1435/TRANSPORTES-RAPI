package Controlador;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author Ricardo
 */
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/ControladorUsuario"})
public class ControladorUsuario extends HttpServlet {
UsuarioDAO dao=new UsuarioDAO();
Usuario u = new Usuario();
int r;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String accion=request.getParameter("accion");
       if(accion.equals("Ingresar")){
           String correo=request.getParameter("txtcorreo");
           String pass=request.getParameter("txtcontra");
            u.setCorreo(correo);
            u.setPass(pass);
            r=dao.validar(u);
            if(r==1){
                request.getSession().setAttribute("pass", pass);
                request.getSession().setAttribute("correo", correo);
                request.getRequestDispatcher("principal.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("loginIncorrecto.jsp").forward(request, response);
            }
       } else{
           request.getRequestDispatcher("index.jsp").forward(request, response);
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
       String accion=request.getParameter("accion");
       switch (accion){
           case "Registrar":
                String correo=request.getParameter("ingresoCorreo");
                String pass=request.getParameter("ingresoPass");
                u.setCorreo(correo);
                u.setPass(pass);
                dao.agregar(u);
                break;
           default: throw new AssertionError();
       }
        if(accion.equals("Registrar")){
           String correo=request.getParameter("ingresoCorreo");
           String pass=request.getParameter("ingresoPass");
            u.setCorreo(correo);
            u.setPass(pass);
            r=dao.validar(u);
            if(r==1){
                request.getRequestDispatcher("registroCorrecto.jsp").forward(request, response);
            }else{
               request.getRequestDispatcher("registroIncorrecto.jsp").forward(request, response);
          }
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
