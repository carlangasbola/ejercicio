package paquete.sgr.entity.pojos;
// Generated 7/12/2018 03:49:07 PM by Hibernate Tools 4.3.1



/**
 * ReactivoUtilizado generated by hbm2java
 */
public class ReactivoUtilizado  implements java.io.Serializable {


     private Integer idReactivoUtilizado;
     private Reactivos reactivos;
     private SesionDeLaboratorio sesionDeLaboratorio;
     private double cantidad;

    public ReactivoUtilizado() {
    }

    public ReactivoUtilizado(Reactivos reactivos, SesionDeLaboratorio sesionDeLaboratorio, double cantidad) {
       this.reactivos = reactivos;
       this.sesionDeLaboratorio = sesionDeLaboratorio;
       this.cantidad = cantidad;
    }
   
    public Integer getIdReactivoUtilizado() {
        return this.idReactivoUtilizado;
    }
    
    public void setIdReactivoUtilizado(Integer idReactivoUtilizado) {
        this.idReactivoUtilizado = idReactivoUtilizado;
    }
    public Reactivos getReactivos() {
        return this.reactivos;
    }
    
    public void setReactivos(Reactivos reactivos) {
        this.reactivos = reactivos;
    }
    public SesionDeLaboratorio getSesionDeLaboratorio() {
        return this.sesionDeLaboratorio;
    }
    
    public void setSesionDeLaboratorio(SesionDeLaboratorio sesionDeLaboratorio) {
        this.sesionDeLaboratorio = sesionDeLaboratorio;
    }
    public double getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }




}


