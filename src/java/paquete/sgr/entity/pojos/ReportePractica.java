package paquete.sgr.entity.pojos;
// Generated 24/11/2018 01:04:58 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ReportePractica generated by hbm2java
 */
public class ReportePractica  implements java.io.Serializable {


     private Integer idReportePractica;
     private Usuarios usuarios;
     private byte[] documentoPractica;
     private Date fecha;
     private double calificacion;
     private String observaciones;
     private String grupo;

    public ReportePractica() {
    }

	
    public ReportePractica(Usuarios usuarios, byte[] documentoPractica, Date fecha, double calificacion, String grupo) {
        this.usuarios = usuarios;
        this.documentoPractica = documentoPractica;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.grupo = grupo;
    }
    public ReportePractica(Usuarios usuarios, byte[] documentoPractica, Date fecha, double calificacion, String observaciones, String grupo) {
       this.usuarios = usuarios;
       this.documentoPractica = documentoPractica;
       this.fecha = fecha;
       this.calificacion = calificacion;
       this.observaciones = observaciones;
       this.grupo = grupo;
    }
   
    public Integer getIdReportePractica() {
        return this.idReportePractica;
    }
    
    public void setIdReportePractica(Integer idReportePractica) {
        this.idReportePractica = idReportePractica;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public byte[] getDocumentoPractica() {
        return this.documentoPractica;
    }
    
    public void setDocumentoPractica(byte[] documentoPractica) {
        this.documentoPractica = documentoPractica;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }




}


