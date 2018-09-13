package modelobase;
// Generated 26/08/2018 08:42:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * EquipoLaboratorio generated by hbm2java
 */
public class EquipoLaboratorio  implements java.io.Serializable {


     private Integer idEquipoLaboratorio;
     private String nombre;
     private String caracteristicas;
     private byte existenciaInventario;
     private Set equipoUtilizados = new HashSet(0);
     private Set historialEquipos = new HashSet(0);

    public EquipoLaboratorio() {
    }

	
    public EquipoLaboratorio(String nombre, String caracteristicas, byte existenciaInventario) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.existenciaInventario = existenciaInventario;
    }
    public EquipoLaboratorio(String nombre, String caracteristicas, byte existenciaInventario, Set equipoUtilizados, Set historialEquipos) {
       this.nombre = nombre;
       this.caracteristicas = caracteristicas;
       this.existenciaInventario = existenciaInventario;
       this.equipoUtilizados = equipoUtilizados;
       this.historialEquipos = historialEquipos;
    }
   
    public Integer getIdEquipoLaboratorio() {
        return this.idEquipoLaboratorio;
    }
    
    public void setIdEquipoLaboratorio(Integer idEquipoLaboratorio) {
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
    public byte getExistenciaInventario() {
        return this.existenciaInventario;
    }
    
    public void setExistenciaInventario(byte existenciaInventario) {
        this.existenciaInventario = existenciaInventario;
    }
    public Set getEquipoUtilizados() {
        return this.equipoUtilizados;
    }
    
    public void setEquipoUtilizados(Set equipoUtilizados) {
        this.equipoUtilizados = equipoUtilizados;
    }
    public Set getHistorialEquipos() {
        return this.historialEquipos;
    }
    
    public void setHistorialEquipos(Set historialEquipos) {
        this.historialEquipos = historialEquipos;
    }




}

