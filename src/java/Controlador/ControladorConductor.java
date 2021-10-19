package Controlador;
import Modelo.Conductor;
import Modelo.ConductorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
@WebServlet(name = "ControladorConductor", urlPatterns = {"/ControladorConductor"})
public class ControladorConductor extends HttpServlet {
ConductorDAO dao=new ConductorDAO();
Conductor cond = new Conductor();
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorConductor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorConductor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
           case "Listar":
                List<Conductor>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("ConductorIndex.jsp").forward(request, response);
                break;
             case "Nuevo":
                request.getRequestDispatcher("AddConductor.jsp").forward(request, response);
                break;
            case "Guardar":
                String idConductor=request.getParameter("ingresoIdConductor");
                String nombresConductor=request.getParameter("ingresoNombresConductor");
                String apellidosConductor=request.getParameter("ingresoApellidosConductor");
                cond.setIdConductor(idConductor);
                cond.setNombresConductor(nombresConductor);
                cond.setApellidosConductor(apellidosConductor);
                dao.agregar(cond);
                request.getRequestDispatcher("ControladorConductor?accion=Listar").forward(request, response);
                break;
             case "Editar":
                String idConductor2=request.getParameter("idConductor");
                Conductor co=dao.listarID(idConductor2);
                request.setAttribute("conductor", co);
                request.getRequestDispatcher("EditConductor.jsp").forward(request, response);
                break;
            case "Actualizar":
                String idConductor3=request.getParameter("ingresoIdConductor");
                String nombresConductor2=request.getParameter("ingresoNombresConductor");
                String apellidosConductor2=request.getParameter("ingresoApellidosConductor");
                cond.setIdConductor(idConductor3);
                cond.setNombresConductor(nombresConductor2);
                cond.setApellidosConductor(apellidosConductor2);
                dao.actualizar(cond);
                request.getRequestDispatcher("ControladorConductor?accion=Listar").forward(request, response);
                break;
           case "Eliminar":
                String idConductor4=request.getParameter("idConductor");
                dao.eliminar(idConductor4);
                 break;
            case "Buscar":
                String dato=request.getParameter("ingresoBuscar");
                List <Conductor> lista = dao.buscar(dato);
                request.setAttribute("datos", lista);
                request.getRequestDispatcher("ConductorIndex.jsp").forward(request, response);
                break;
            default: throw new AssertionError();

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
