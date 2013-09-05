package jw0rmc.timeline;
// Generated 28/08/2013 03:43:13 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Elementos generated by hbm2java
 */
public class Elementos  implements java.io.Serializable {


     private int id;
     private Auxiliar auxiliar;
     private String nombre;
     private String descripcion;
     private Date inicio;
     private Date final_;

    public Elementos() {
    }

	
    public Elementos(int id) {
        this.id = id;
    }
    public Elementos(int id, Auxiliar auxiliar, String nombre, String descripcion, Date inicio, Date final_) {
       this.id = id;
       this.auxiliar = auxiliar;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.inicio = inicio;
       this.final_ = final_;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Auxiliar getAuxiliar() {
        return this.auxiliar;
    }
    
    public void setAuxiliar(Auxiliar auxiliar) {
        this.auxiliar = auxiliar;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getInicio() {
        return this.inicio;
    }
    
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
    public Date getFinal_() {
        return this.final_;
    }
    
    public void setFinal_(Date final_) {
        this.final_ = final_;
    }




}

