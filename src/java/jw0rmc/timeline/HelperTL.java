/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jw0rmc.timeline;



import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DellXps15
 */
public class HelperTL {
     Session session=null;
   
    
    public HelperTL(){
   this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }  
    
      public List<Elementos> getElementos() {
    List<Elementos> elementos=null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Elementos");
        elementos = (List<Elementos>) q.list();
        
    } catch (Exception e) {
      e.printStackTrace();
    }
    return elementos;
}
      
      public boolean addElement(String nombre,String descripcion, Date inicio,Date final_){
      Elementos elemento=null;
      Auxiliar auxiliar=null;
      try{
      org.hibernate.Transaction tx= session.beginTransaction();
      Query q=session.createQuery("from Auxiliar where id=1");
      auxiliar =(Auxiliar) q.uniqueResult();
      q = session.createQuery (" from Elementos where id=(select max(id) from Elementos) ");
      Elementos elementoUltimo = (Elementos) q.uniqueResult();
      
      elemento=new Elementos(elementoUltimo.getId()+1, auxiliar, nombre,descripcion,inicio, final_);
      
      session.save(elemento);
      session.getTransaction().commit();
      return true;
      }catch(Exception e){
      e.printStackTrace();
      return false;
      }
     
      }
      
  
public boolean eliminaElement(String id){

        try {
        Session session=this.session.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("delete  from Elementos where id="+Integer.parseInt(id));
        int result=q.executeUpdate();
        session.getTransaction().commit();
        return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } 
} 

public boolean doActualizacionElemento(String id,String nombre,String descripcion, Date inicio,Date final_) {
      Elementos elemento=null;
      Auxiliar auxiliar=null;
     
    try {
        
        Session session=this.session.getSessionFactory().openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q=session.createQuery("from Elementos where id="+Integer.parseInt(id));
        elemento=(Elementos)q.uniqueResult();
        elemento.setNombre(nombre);
        elemento.setDescripcion(descripcion);
        elemento.setInicio(inicio);
        elemento.setFinal_(final_);
        
        session.update(elemento);
        session.getTransaction().commit();
        return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
   
}
  
}
