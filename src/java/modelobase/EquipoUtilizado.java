package modelobase;
// Generated 30/09/2018 04:25:13 PM by Hibernate Tools 4.3.1



/**
 * EquipoUtilizado generated by hbm2java
 */
public class EquipoUtilizado  implements java.io.Serializable {


     private Integer idEquipoUtilizado;
     private DatosPractica datosPractica;
     private EquipoLaboratorio equipoLaboratorio;

    public EquipoUtilizado() {
    }

    public EquipoUtilizado(DatosPractica datosPractica, EquipoLaboratorio equipoLaboratorio) {
       this.datosPractica = datosPractica;
       this.equipoLaboratorio = equipoLaboratorio;
    }
   
    public Integer getIdEquipoUtilizado() {
        return this.idEquipoUtilizado;
    }
    
    public void setIdEquipoUtilizado(Integer idEquipoUtilizado) {
        this.idEquipoUtilizado = idEquipoUtilizado;
    }
    public DatosPractica getDatosPractica() {
        return this.datosPractica;
    }
    
    public void setDatosPractica(DatosPractica datosPractica) {
        this.datosPractica = datosPractica;
    }
    public EquipoLaboratorio getEquipoLaboratorio() {
        return this.equipoLaboratorio;
    }
    
    public void setEquipoLaboratorio(EquipoLaboratorio equipoLaboratorio) {
        this.equipoLaboratorio = equipoLaboratorio;
    }




}


