package paquete.sgr.entity.pojos;
// Generated 7/12/2018 03:49:07 PM by Hibernate Tools 4.3.1


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
     private Set reactivosUtilizadoPracticas = new HashSet(0);
     private Set materialUtilizados = new HashSet(0);
     private Set equipoUtilizados = new HashSet(0);
     private Set notificacionesPracticas = new HashSet(0);
     private DatosPractica datosPractica;

    public Practica() {
    }

	
    public Practica(UnidadTematica unidadTematica, Usuarios usuarios, Date creacion) {
        this.unidadTematica = unidadTematica;
        this.usuarios = usuarios;
        this.creacion = creacion;
    }
    public Practica(UnidadTematica unidadTematica, Usuarios usuarios, Date creacion, Set reactivosUtilizadoPracticas, Set materialUtilizados, Set equipoUtilizados, Set notificacionesPracticas, DatosPractica datosPractica) {
       this.unidadTematica = unidadTematica;
       this.usuarios = usuarios;
       this.creacion = creacion;
       this.reactivosUtilizadoPracticas = reactivosUtilizadoPracticas;
       this.materialUtilizados = materialUtilizados;
       this.equipoUtilizados = equipoUtilizados;
       this.notificacionesPracticas = notificacionesPracticas;
       this.datosPractica = datosPractica;
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
    public Set getReactivosUtilizadoPracticas() {
        return this.reactivosUtilizadoPracticas;
    }
    
    public void setReactivosUtilizadoPracticas(Set reactivosUtilizadoPracticas) {
        this.reactivosUtilizadoPracticas = reactivosUtilizadoPracticas;
    }
    public Set getMaterialUtilizados() {
        return this.materialUtilizados;
    }
    
    public void setMaterialUtilizados(Set materialUtilizados) {
        this.materialUtilizados = materialUtilizados;
    }
    public Set getEquipoUtilizados() {
        return this.equipoUtilizados;
    }
    
    public void setEquipoUtilizados(Set equipoUtilizados) {
        this.equipoUtilizados = equipoUtilizados;
    }
    public Set getNotificacionesPracticas() {
        return this.notificacionesPracticas;
    }
    
    public void setNotificacionesPracticas(Set notificacionesPracticas) {
        this.notificacionesPracticas = notificacionesPracticas;
    }
    public DatosPractica getDatosPractica() {
        return this.datosPractica;
    }
    
    public void setDatosPractica(DatosPractica datosPractica) {
        this.datosPractica = datosPractica;
    }




}


