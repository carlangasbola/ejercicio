package paquete.sgr.entity.pojos;
// Generated 20/10/2018 05:28:52 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Practica generated by hbm2java
 */
public class Practica  implements java.io.Serializable {


     private Integer idPractica;
     private UnidadTematica unidadTematica;
     private Usuarios usuarios;
     private Date creacion;
     private Set notificacionesPracticas = new HashSet(0);
     private Set datosPracticas = new HashSet(0);

    public Practica() {
    }

	
    public Practica(UnidadTematica unidadTematica, Usuarios usuarios, Date creacion) {
        this.unidadTematica = unidadTematica;
        this.usuarios = usuarios;
        this.creacion = creacion;
    }
    public Practica(UnidadTematica unidadTematica, Usuarios usuarios, Date creacion, Set notificacionesPracticas, Set datosPracticas) {
       this.unidadTematica = unidadTematica;
       this.usuarios = usuarios;
       this.creacion = creacion;
       this.notificacionesPracticas = notificacionesPracticas;
       this.datosPracticas = datosPracticas;
    }
   
    public Integer getIdPractica() {
        return this.idPractica;
    }
    
    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }
    public UnidadTematica getUnidadTematica() {
        return this.unidadTematica;
    }
    
    public void setUnidadTematica(UnidadTematica unidadTematica) {
        this.unidadTematica = unidadTematica;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public Date getCreacion() {
        return this.creacion;
    }
    
    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }
    public Set getNotificacionesPracticas() {
        return this.notificacionesPracticas;
    }
    
    public void setNotificacionesPracticas(Set notificacionesPracticas) {
        this.notificacionesPracticas = notificacionesPracticas;
    }
    public Set getDatosPracticas() {
        return this.datosPracticas;
    }
    
    public void setDatosPracticas(Set datosPracticas) {
        this.datosPracticas = datosPracticas;
    }




}

