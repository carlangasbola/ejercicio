package paquete.sgr.entity.pojos;
// Generated 16/11/2018 11:10:37 PM by Hibernate Tools 4.3.1



/**
 * Vale generated by hbm2java
 */
public class Vale  implements java.io.Serializable {


     private Integer idVale;
     private Equipo equipo;
     private SesionDeLaboratorio sesionDeLaboratorio;
     private byte[] vale;
     private String status;

    public Vale() {
    }

    public Vale(Equipo equipo, SesionDeLaboratorio sesionDeLaboratorio, byte[] vale, String status) {
       this.equipo = equipo;
       this.sesionDeLaboratorio = sesionDeLaboratorio;
       this.vale = vale;
       this.status = status;
    }
   
    public Integer getIdVale() {
        return this.idVale;
    }
    
    public void setIdVale(Integer idVale) {
        this.idVale = idVale;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public SesionDeLaboratorio getSesionDeLaboratorio() {
        return this.sesionDeLaboratorio;
    }
    
    public void setSesionDeLaboratorio(SesionDeLaboratorio sesionDeLaboratorio) {
        this.sesionDeLaboratorio = sesionDeLaboratorio;
    }
    public byte[] getVale() {
        return this.vale;
    }
    
    public void setVale(byte[] vale) {
        this.vale = vale;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


