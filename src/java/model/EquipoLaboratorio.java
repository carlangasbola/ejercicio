package model;
// Generated 14/07/2018 10:59:12 PM by Hibernate Tools 4.3.1



/**
 * EquipoLaboratorio generated by hbm2java
 */
public class EquipoLaboratorio  implements java.io.Serializable {


     private int idEquipoLaboratorio;
     private String nombre;
     private String caracteristicas;

    public EquipoLaboratorio() {
    }

    public EquipoLaboratorio(int idEquipoLaboratorio, String nombre, String caracteristicas) {
       this.idEquipoLaboratorio = idEquipoLaboratorio;
       this.nombre = nombre;
       this.caracteristicas = caracteristicas;
    }
   
    public int getIdEquipoLaboratorio() {
        return this.idEquipoLaboratorio;
    }
    
    public void setIdEquipoLaboratorio(int idEquipoLaboratorio) {
        this.idEquipoLaboratorio = idEquipoLaboratorio;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCaracteristicas() {
        return this.caracteristicas;
    }
    
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }




}


