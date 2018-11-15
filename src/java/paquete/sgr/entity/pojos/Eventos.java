package paquete.sgr.entity.pojos;
// Generated 14/11/2018 08:24:45 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Eventos generated by hbm2java
 */
public class Eventos  implements java.io.Serializable {


     private Integer idEventos;
     private Grupo grupo;
     private UnidadGrupo unidadGrupo;
     private String tipo;
     private String nombre;
     private Date fecha;
     private String descripcion;

    public Eventos() {
    }

	
    public Eventos(Grupo grupo, UnidadGrupo unidadGrupo, String tipo, String nombre, Date fecha) {
        this.grupo = grupo;
        this.unidadGrupo = unidadGrupo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.fecha = fecha;
    }
    public Eventos(Grupo grupo, UnidadGrupo unidadGrupo, String tipo, String nombre, Date fecha, String descripcion) {
       this.grupo = grupo;
       this.unidadGrupo = unidadGrupo;
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
    public UnidadGrupo getUnidadGrupo() {
        return this.unidadGrupo;
    }
    
    public void setUnidadGrupo(UnidadGrupo unidadGrupo) {
        this.unidadGrupo = unidadGrupo;
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


