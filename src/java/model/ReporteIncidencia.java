package model;
// Generated 14/07/2018 10:59:12 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ReporteIncidencia generated by hbm2java
 */
public class ReporteIncidencia  implements java.io.Serializable {


     private int idReporte;
     private String nombre;
     private byte[] documento;
     private Date fecha;
     private String estado;
     private Date actualizacion;
     private Set historialEmergencias = new HashSet(0);

    public ReporteIncidencia() {
    }

	
    public ReporteIncidencia(int idReporte, String nombre, byte[] documento, Date fecha, String estado, Date actualizacion) {
        this.idReporte = idReporte;
        this.nombre = nombre;
        this.documento = documento;
        this.fecha = fecha;
        this.estado = estado;
        this.actualizacion = actualizacion;
    }
    public ReporteIncidencia(int idReporte, String nombre, byte[] documento, Date fecha, String estado, Date actualizacion, Set historialEmergencias) {
       this.idReporte = idReporte;
       this.nombre = nombre;
       this.documento = documento;
       this.fecha = fecha;
       this.estado = estado;
       this.actualizacion = actualizacion;
       this.historialEmergencias = historialEmergencias;
    }
   
    public int getIdReporte() {
        return this.idReporte;
    }
    
    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public byte[] getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(byte[] documento) {
        this.documento = documento;
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


