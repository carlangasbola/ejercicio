package paquete.sgr.entity.pojos;
// Generated 9/11/2018 11:27:59 PM by Hibernate Tools 4.3.1



/**
 * EquipoUtilizado generated by hbm2java
 */
public class EquipoUtilizado  implements java.io.Serializable {


     private Integer idEquipoUtilizado;
     private EquipoLaboratorio equipoLaboratorio;
     private int idDatos;

    public EquipoUtilizado() {
    }

    public EquipoUtilizado(EquipoLaboratorio equipoLaboratorio, int idDatos) {
       this.equipoLaboratorio = equipoLaboratorio;
       this.idDatos = idDatos;
    }
   
    public Integer getIdEquipoUtilizado() {
        return this.idEquipoUtilizado;
    }
    
    public void setIdEquipoUtilizado(Integer idEquipoUtilizado) {
        this.idEquipoUtilizado = idEquipoUtilizado;
    }
    public EquipoLaboratorio getEquipoLaboratorio() {
        return this.equipoLaboratorio;
    }
    
    public void setEquipoLaboratorio(EquipoLaboratorio equipoLaboratorio) {
        this.equipoLaboratorio = equipoLaboratorio;
    }
    public int getIdDatos() {
        return this.idDatos;
    }
    
    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }




}


