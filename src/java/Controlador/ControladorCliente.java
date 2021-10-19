package Controlador;
import Modelo.Cliente;
import Modelo.ClienteDAO;
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
@WebServlet(name = "ControladorCliente", urlPatterns = {"/ControladorCliente"})
public class ControladorCliente extends HttpServlet {
ClienteDAO dao=new ClienteDAO();
Cliente cli = new Cliente();
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
            out.println("<title>Servlet ControladorCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
                List<Cliente>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("ClienteIndex.jsp").forward(request, response);
                break;
           case "Nuevo":
                request.getRequestDispatcher("AddCliente.jsp").forward(request, response);
                break;
            case "Guardar":
                String idCliente=request.getParameter("ingresoIdCliente");
                String dpi=request.getParameter("ingresoDPI");
                String nombresCliente=request.getParameter("ingresoNombresCliente");
                String apellidosCliente=request.getParameter("ingresoApellidosCliente");
                String edadCliente = request.getParameter("ingresoEdadCliente");
                cli.setIdCliente(idCliente);
                cli.setDpi(dpi);
                cli.setNombresCliente(nombresCliente);
                cli.setApellidosCliente(apellidosCliente);
                cli.setEdadCliente(edadCliente);
                dao.agregar(cli);
                request.getRequestDispatcher("ControladorCliente?accion=Listar").forward(request, response);
                break;
            case "Editar":
                String idCliente1=request.getParameter("idCliente");
                Cliente cl=dao.listarID(idCliente1);
                request.setAttribute("cliente", cl);
                request.getRequestDispatcher("EditCliente.jsp").forward(request, response);
                break;
            case "Actualizar":
                String id2=request.getParameter("ingresoIdCliente");
                String dpi2=request.getParameter("ingresoDPI");
                String nombre2=request.getParameter("ingresoNombresCliente");
                String apellido2=request.getParameter("ingresoApellidosCliente");
                String alias2=request.getParameter("ingresoEdadCliente");
                cli.setIdCliente(id2);
                cli.setDpi(dpi2);
                cli.setNombresCliente(nombre2);
                cli.setApellidosCliente(apellido2);
                cli.setEdadCliente(alias2);
                dao.actualizar(cli);
                request.getRequestDispatcher("ControladorCliente?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                String id3=request.getParameter("idCliente");
                dao.eliminar(id3);
                 break;
            case "Buscar":
                String dato=request.getParameter("ingresoBuscar");
                List <Cliente> lista = dao.buscar(dato);
                request.setAttribute("datos", lista);
                request.getRequestDispatcher("ClienteIndex.jsp").forward(request, response);
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
