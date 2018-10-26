package paquete.sgr.entity.pojos;
// Generated 20/10/2018 05:28:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UnidadGrupo generated by hbm2java
 */
public class UnidadGrupo  implements java.io.Serializable {


     private Integer idUnidadGrupo;
     private Grupo grupo;
     private UnidadAprendizaje unidadAprendizaje;
     private Usuarios usuarios;
     private Set listaGrupos = new HashSet(0);

    public UnidadGrupo() {
    }

	
    public UnidadGrupo(Grupo grupo, UnidadAprendizaje unidadAprendizaje, Usuarios usuarios) {
        this.grupo = grupo;
        this.unidadAprendizaje = unidadAprendizaje;
        this.usuarios = usuarios;
    }
    public UnidadGrupo(Grupo grupo, UnidadAprendizaje unidadAprendizaje, Usuarios usuarios, Set listaGrupos) {
       this.grupo = grupo;
       this.unidadAprendizaje = unidadAprendizaje;
       this.usuarios = usuarios;
       this.listaGrupos = listaGrupos;
    }
   
    public Integer getIdUnidadGrupo() {
        return this.idUnidadGrupo;
    }
    
    public void setIdUnidadGrupo(Integer idUnidadGrupo) {
        this.idUnidadGrupo = idUnidadGrupo;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public UnidadAprendizaje getUnidadAprendizaje() {
        return this.unidadAprendizaje;
    }
    
    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public Set getListaGrupos() {
        return this.listaGrupos;
    }
    
    public void setListaGrupos(Set listaGrupos) {
        this.listaGrupos = listaGrupos;
    }




}

