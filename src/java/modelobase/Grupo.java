package modelobase;
// Generated 5/10/2018 05:18:07 PM by Hibernate Tools 4.3.1


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
     private Set eventoses = new HashSet(0);
     private Set listaGrupos = new HashSet(0);
     private Set sesionDeLaboratorios = new HashSet(0);

    public Grupo() {
    }

	
    public Grupo(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
    }
    public Grupo(String nombre, int cupo, Set unidadGrupos, Set eventoses, Set listaGrupos, Set sesionDeLaboratorios) {
       this.nombre = nombre;
       this.cupo = cupo;
       this.unidadGrupos = unidadGrupos;
       this.eventoses = eventoses;
       this.listaGrupos = listaGrupos;
       this.sesionDeLaboratorios = sesionDeLaboratorios;
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
    public Set getEventoses() {
        return this.eventoses;
    }
    
    public void setEventoses(Set eventoses) {
        this.eventoses = eventoses;
    }
    public Set getListaGrupos() {
        return this.listaGrupos;
    }
    
    public void setListaGrupos(Set listaGrupos) {
        this.listaGrupos = listaGrupos;
    }
    public Set getSesionDeLaboratorios() {
        return this.sesionDeLaboratorios;
    }
    
    public void setSesionDeLaboratorios(Set sesionDeLaboratorios) {
        this.sesionDeLaboratorios = sesionDeLaboratorios;
    }




}


