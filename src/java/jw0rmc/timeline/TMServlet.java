/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jw0rmc.timeline;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DellXps15
 */
public class TMServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean proceder=false,procederEliminarActualizar=false;
        int opc=0;
        String errExceptions="";
        try {
            /* TODO output your page here. You may use following sample code. */
        
            String opcion=request.getParameter("opc");
            if( opcion != null && opcion.length()>0){
            
            try{
            opc=Integer.parseInt(opcion);
            proceder=true;
            }catch(Exception e){
                System.out.println(" " + e.toString());
                errExceptions=e.toString();
            }
            }else
            proceder=false;
            
            
            
            String id=request.getParameter("id");
            if( id != null && id.length()>0)
            procederEliminarActualizar=true;
            else
            procederEliminarActualizar=false;
            
            String nom=request.getParameter("nom");
            if( nom != null && nom.length()>0)
            proceder=true;
            else
            proceder=false;
            
            String desc=request.getParameter("desc");
            if( desc != null && desc.length()>0)
            proceder=true;
            else
            proceder=false;
            
            String ini=request.getParameter("ini");
            if(ini != null && ini.length()>0)
            proceder=true;
            else
            proceder=false;
            
            String fin=request.getParameter("fin");
            if(fin!= null && fin.length()>0)
            proceder=true;
            else
            proceder=false;
             
            switch(opc){
            
                case 1:
                                if(proceder)
                                {
                                    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    Date fechaI = null;
                                    Date fechaF = null;
                                    String fechaInicial=ini,fechaFinal=fin;
                                    try {
                                    fechaI = formatoDelTexto.parse(fechaInicial);
                                    fechaF = formatoDelTexto.parse(fechaFinal);
                                    } catch (ParseException ex) {
                                    ex.printStackTrace();
                                     out.println("<h1>Adding: "+ex.toString()+"</h1>");
                                    }
                                    new ControllerTL(Path.PATH).addElemento(nom,desc, fechaI, fechaF);

                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Add Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Added: "+nom+"</h1><br>");
                                out.println("<h1>desc: "+desc+"</h2><br>");
                                out.println("<h1>ini: "+ini+"</h2>  <br>");
                                out.println("<h1>fin: "+fin+"</h2>  <br>");

                                out.println("<h1>generando Json Source: "+new ControllerTL(Path.PATH).creaHistoricoAJsonTimeline("fileprueba")+"</h2><br>");

                                out.println("</body>");
                                out.println("</html>");

                                }else{
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Add Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Err.  proceder : "+proceder+"</h1>");
                                out.println("</body>");
                                out.println("</html>");
                                }
                    break;
                case 2:
                    out.print(new ControllerTL(Path.PATH).consultaHistoricoJsonTimeline("fileprueba"));
                    break;
                case 3:
                     if(procederEliminarActualizar)
                                {
                              
                                new ControllerTL(Path.PATH).eliminaElemento(id);

                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Add Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Eliminado: "+id+"</h1><br>");
                                out.println("</body>");
                                out.println("</html>");

                                }else{
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Add Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Err.  Eliminando : id invalido o no existe</h1>");
                                out.println("</body>");
                                out.println("</html>");
                                }
                    break;
                    case 4:
                     if(procederEliminarActualizar)
                                {
                                    
                                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                                    Date fechaI = null;
                                    Date fechaF = null;
                                    String fechaInicial=ini,fechaFinal=fin;
                                    try {
                                    fechaI = formatoDelTexto.parse(fechaInicial);
                                    fechaF = formatoDelTexto.parse(fechaFinal);
                                    } catch (ParseException ex) {
                                      out.println("<h1>Actualizando: "+ex.toString()+"</h1>");
                                    }
                                new ControllerTL(Path.PATH).actualizaElemento(id,nom,desc, fechaI, fechaF);

                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Add Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Actualizado: "+id+"</h1><br>");
                                out.println("</body>");
                                out.println("</html>");

                                }else{
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Update Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Err.  Actualizando : id invalido o no existe</h1>");
                                out.println("</body>");
                                out.println("</html>");
                                }
                    break;
                default:
                     out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>TimeLine Service Default Lanconta Running..</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h1>Err.  default : opcion de servicio desconocida</h1>");
                                out.println("<h1>Err.  desc : "+errExceptions+"</h1>");
                                out.println("</body>");
                                out.println("</html>");
                    break;
            }
            
        
        
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
