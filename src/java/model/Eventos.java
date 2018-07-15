package model;
// Generated 14/07/2018 10:59:12 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Eventos generated by hbm2java
 */
public class Eventos  implements java.io.Serializable {


     private int idEventos;
     private String tipo;
     private String nombre;
     private Date fecha;
     private String descripcion;

    public Eventos() {
    }

	
    public Eventos(int idEventos, String tipo, String nombre, Date fecha) {
        this.idEventos = idEventos;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    public Eventos(int idEventos, String tipo, String nombre, Date fecha, String descripcion) {
       this.idEventos = idEventos;
       this.tipo = tipo;
       this.nombre = nombre;
       this.fecha = fecha;
       this.descripcion = descripcion;
    }
   
    public int getIdEventos() {
        return this.idEventos;
    }
    
    public void setIdEventos(int idEventos) {
        this.idEventos = idEventos;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


