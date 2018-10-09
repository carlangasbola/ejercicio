package modelobase;
// Generated 5/10/2018 05:18:07 PM by Hibernate Tools 4.3.1



/**
 * NotificacionesSesion generated by hbm2java
 */
public class NotificacionesSesion  implements java.io.Serializable {


     private Integer idNotificacion;
     private SesionDeLaboratorio sesionDeLaboratorio;
     private String descripcion;
     private byte estado;

    public NotificacionesSesion() {
    }

    public NotificacionesSesion(SesionDeLaboratorio sesionDeLaboratorio, String descripcion, byte estado) {
       this.sesionDeLaboratorio = sesionDeLaboratorio;
       this.descripcion = descripcion;
       this.estado = estado;
    }
   
    public Integer getIdNotificacion() {
        return this.idNotificacion;
    }
    
    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }
    public SesionDeLaboratorio getSesionDeLaboratorio() {
        return this.sesionDeLaboratorio;
    }
    
    public void setSesionDeLaboratorio(SesionDeLaboratorio sesionDeLaboratorio) {
        this.sesionDeLaboratorio = sesionDeLaboratorio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public byte getEstado() {
        return this.estado;
    }
    
    public void setEstado(byte estado) {
        this.estado = estado;
    }




}


