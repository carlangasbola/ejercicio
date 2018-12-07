package paquete.sgr.entity.pojos;
// Generated 7/12/2018 03:49:07 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ReporteIncidencia generated by hbm2java
 */
public class ReporteIncidencia  implements java.io.Serializable {


     private Integer idReporte;
     private SesionDeLaboratorio sesionDeLaboratorio;
     private String nombre;
     private String observaciones;
     private Date fecha;
     private String estado;
     private Date actualizacion;
     private Set historialEmergencias = new HashSet(0);

    public ReporteIncidencia() {
    }

	
    public ReporteIncidencia(SesionDeLaboratorio sesionDeLaboratorio, String nombre, String observaciones, Date fecha, String estado, Date actualizacion) {
        this.sesionDeLaboratorio = sesionDeLaboratorio;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.estado = estado;
        this.actualizacion = actualizacion;
    }
    public ReporteIncidencia(SesionDeLaboratorio sesionDeLaboratorio, String nombre, String observaciones, Date fecha, String estado, Date actualizacion, Set historialEmergencias) {
       this.sesionDeLaboratorio = sesionDeLaboratorio;
       this.nombre = nombre;
       this.observaciones = observaciones;
       this.fecha = fecha;
       this.estado = estado;
       this.actualizacion = actualizacion;
       this.historialEmergencias = historialEmergencias;
    }
   
    public Integer getIdReporte() {
        return this.idReporte;
    }
    
    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }
    public SesionDeLaboratorio getSesionDeLaboratorio() {
        return this.sesionDeLaboratorio;
    }
    
    public void setSesionDeLaboratorio(SesionDeLaboratorio sesionDeLaboratorio) {
        this.sesionDeLaboratorio = sesionDeLaboratorio;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getActualizacion() {
        return this.actualizacion;
    }
    
    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }
    public Set getHistorialEmergencias() {
        return this.historialEmergencias;
    }
    
    public void setHistorialEmergencias(Set historialEmergencias) {
        this.historialEmergencias = historialEmergencias;
    }




}


