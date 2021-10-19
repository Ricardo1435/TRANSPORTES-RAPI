package Controlador;
import Modelo.Destino;
import Modelo.DestinoDAO;
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
@WebServlet(name = "ControladorDestino", urlPatterns = {"/ControladorDestino"})
public class ControladorDestino extends HttpServlet {
Destino des = new Destino();
DestinoDAO dao = new DestinoDAO();
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
            out.println("<title>Servlet ControladorDestino</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDestino at " + request.getContextPath() + "</h1>");
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
                List<Destino>datos=dao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("DestinoIndex.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("AddDestino.jsp").forward(request, response);
                break;
            case "Guardar":
                String idDestino=request.getParameter("ingresoIdDestino");
                String nombreDestino=request.getParameter("ingresoNombreDestino");
                String precioBoleto=request.getParameter("ingresoPrecioBoleto");
                String matricula=request.getParameter("ingresoMatricula");
                des.setIdDestino(idDestino);
                des.setNombreDestino(nombreDestino);
                des.setPrecioBoleto(precioBoleto);
                des.setMatricula(matricula);
                dao.agregar(des);
                request.getRequestDispatcher("ControladorDestino?accion=Listar").forward(request, response);
                break;
            case "Editar":
                String idDestino2=request.getParameter("idDestino");
                Destino de=dao.listarID(idDestino2);
                request.setAttribute("destino", de);
                request.getRequestDispatcher("EditDestino.jsp").forward(request, response);
                break;
            case "Actualizar":
                String idDestino3=request.getParameter("ingresoIdDestino");
                String nombreDestino3=request.getParameter("ingresoNombreDestino");
                String precioBoleto3=request.getParameter("ingresoPrecioBoleto");
                String matricula3=request.getParameter("ingresoMatricula");
                des.setIdDestino(idDestino3);
                des.setNombreDestino(nombreDestino3);
                des.setPrecioBoleto(precioBoleto3);
                des.setMatricula(matricula3);
                dao.actualizar(des);
                request.getRequestDispatcher("ControladorDestino?accion=Listar").forward(request, response);
                break;
             case "Eliminar":
                String idDestino4=request.getParameter("idDestino");
                dao.eliminar(idDestino4);
                 break;
            case "Buscar":
                String dato=request.getParameter("ingresoBuscar");
                List <Destino> lista = dao.buscar(dato);
                request.setAttribute("datos", lista);
                request.getRequestDispatcher("DestinoIndex.jsp").forward(request, response);
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
