package modelobase;
// Generated 26/08/2018 08:42:52 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Eventos generated by hbm2java
 */
public class Eventos  implements java.io.Serializable {


     private Integer idEventos;
     private Grupo grupo;
     private String tipo;
     private String nombre;
     private Date fecha;
     private String descripcion;

    public Eventos() {
    }

	
    public Eventos(Grupo grupo, String tipo, String nombre, Date fecha) {
        this.grupo = grupo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    public Eventos(Grupo grupo, String tipo, String nombre, Date fecha, String descripcion) {
       this.grupo = grupo;
       this.tipo = tipo;
       this.nombre = nombre;
       this.fecha = fecha;
       this.descripcion = descripcion;
    }
   
    public Integer getIdEventos() {
        return this.idEventos;
    }
    
    public void setIdEventos(Integer idEventos) {
        this.idEventos = idEventos;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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

