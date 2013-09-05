/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jw0rmc.timeline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DellXps15
 */
public class ControllerTL {
    HelperTL htl=new HelperTL();
    JsonSimple jsoneitor=new JsonSimple("C:\\Users\\DellXps15\\Documents\\NetBeansProjects\\Uploader\\web\\timeline\\json");
    
    public static void main(String[] args) {
        int opc=5;
        
        switch(opc){
            case 1:
                new ControllerTL().creaHistoricoAJsonTimeline("fileprueba");
                break;
            case 2:
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date fechaI = null;
                Date fechaF = null;
                String fechaInicial="2000-11-02 20:00:00",fechaFinal="2001-09-04 16:00:00";
                try {
                fechaI = formatoDelTexto.parse(fechaInicial);
                fechaF = formatoDelTexto.parse(fechaFinal);
                } catch (ParseException ex) {
                ex.printStackTrace();
                }
                new ControllerTL().addElemento("add2.5", "probando add elements prueba 2.5", fechaI, fechaF);
                break;
            case 3:
                new ControllerTL().consultaHistoricoJsonTimeline("fileprueba");
                break;
            case 4:
                new ControllerTL().eliminaElemento("3");
                break;
            case 5:
                SimpleDateFormat formatoDelTexto2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date fechaI2 = null;
                Date fechaF2 = null;
                String fechaInicial2="2000-08-02 10:00:00",fechaFinal2="2001-06-02 20:00:00";
                try {
                fechaI2 = formatoDelTexto2.parse(fechaInicial2);
                fechaF2 = formatoDelTexto2.parse(fechaFinal2);
                } catch (ParseException ex) {
                ex.printStackTrace();
                }
                new ControllerTL().actualizaElemento("3","updattingProbes", "prueba actualiza", fechaI2, fechaF2);
                break;
            default:
                System.out.println("nacha plus");
                break;
        
                }
    
    
    }
    
    
    
      public boolean creaHistoricoAJsonTimeline(String nombre){
        if(jsoneitor.escribidor(htl.getElementos(),nombre))
            return true;
        else 
            return false;
    
    }
      
      public String consultaHistoricoJsonTimeline(String nombre){
          if(jsoneitor.escribidor(htl.getElementos(),nombre))
            return jsoneitor.leedor(nombre);
        else {
              System.out.println("Err. consultaHistoricoJsonTimelLine!");
            return "";
          }
          
          
    }
      
      public boolean addElemento(String nombre,String descripcion,Date inicio,Date final_){
      
          if(htl.addElement(nombre, descripcion, inicio, final_)){
              System.out.println("add ok");
              return true;
          }else {
              System.out.println("add fault");
              return false;
          }
          
      }
      
      public boolean eliminaElemento(String id){
      
          if(htl.eliminaElement(id))
              return true;
          else 
              return false;
          
      }
      
       public boolean actualizaElemento(String id,String nombre,String descripcion, Date inicio,Date final_){
      
          if(htl.doActualizacionElemento(id,nombre,descripcion,inicio,final_))
              return true;
          else 
              return false;
          
      }
    
}
