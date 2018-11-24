package paquete.sgr.entity.pojos;
// Generated 24/11/2018 01:04:58 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Residuos generated by hbm2java
 */
public class Residuos  implements java.io.Serializable {


     private Integer idResiduo;
     private SesionDeLaboratorio sesionDeLaboratorio;
     private String nombre;
     private String tipo;
     private double cantidad;
     private Date fechaDeIngreso;

    public Residuos() {
    }

    public Residuos(SesionDeLaboratorio sesionDeLaboratorio, String nombre, String tipo, double cantidad, Date fechaDeIngreso) {
       this.sesionDeLaboratorio = sesionDeLaboratorio;
       this.nombre = nombre;
       this.tipo = tipo;
       this.cantidad = cantidad;
       this.fechaDeIngreso = fechaDeIngreso;
    }
   
    public Integer getIdResiduo() {
        return this.idResiduo;
    }
    
    public void setIdResiduo(Integer idResiduo) {
        this.idResiduo = idResiduo;
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
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    public Date getFechaDeIngreso() {
        return this.fechaDeIngreso;
    }
    
    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }




}


