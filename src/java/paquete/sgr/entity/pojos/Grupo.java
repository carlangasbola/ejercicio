package paquete.sgr.entity.pojos;
// Generated 7/12/2018 03:49:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Grupo generated by hbm2java
 */
public class Grupo  implements java.io.Serializable {


     private Integer idGrupo;
     private String nombre;
     private int cupo;
     private Set unidadGrupos = new HashSet(0);

    public Grupo() {
    }

	
    public Grupo(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
    }
    public Grupo(String nombre, int cupo, Set unidadGrupos) {
       this.nombre = nombre;
       this.cupo = cupo;
       this.unidadGrupos = unidadGrupos;
    }
   
    public Integer getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCupo() {
        return this.cupo;
    }
    
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
    public Set getUnidadGrupos() {
        return this.unidadGrupos;
    }
    
    public void setUnidadGrupos(Set unidadGrupos) {
        this.unidadGrupos = unidadGrupos;
    }




}


