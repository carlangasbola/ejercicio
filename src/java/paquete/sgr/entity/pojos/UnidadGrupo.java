package paquete.sgr.entity.pojos;
// Generated 24/11/2018 01:04:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UnidadGrupo generated by hbm2java
 */
public class UnidadGrupo  implements java.io.Serializable {


     private Integer idUnidadGrupo;
     private Grupo grupo;
     private UnidadAprendizaje unidadAprendizaje;
     private Usuarios usuariosByIdUsuariosDocente;
     private Usuarios usuariosByUsuariosIdUsuarios;
     private Set equipos = new HashSet(0);
     private Set listaGrupos = new HashSet(0);
     private Set eventoses = new HashSet(0);

    public UnidadGrupo() {
    }

	
    public UnidadGrupo(Grupo grupo, UnidadAprendizaje unidadAprendizaje, Usuarios usuariosByIdUsuariosDocente, Usuarios usuariosByUsuariosIdUsuarios) {
        this.grupo = grupo;
        this.unidadAprendizaje = unidadAprendizaje;
        this.usuariosByIdUsuariosDocente = usuariosByIdUsuariosDocente;
        this.usuariosByUsuariosIdUsuarios = usuariosByUsuariosIdUsuarios;
    }
    public UnidadGrupo(Grupo grupo, UnidadAprendizaje unidadAprendizaje, Usuarios usuariosByIdUsuariosDocente, Usuarios usuariosByUsuariosIdUsuarios, Set equipos, Set listaGrupos, Set eventoses) {
       this.grupo = grupo;
       this.unidadAprendizaje = unidadAprendizaje;
       this.usuariosByIdUsuariosDocente = usuariosByIdUsuariosDocente;
       this.usuariosByUsuariosIdUsuarios = usuariosByUsuariosIdUsuarios;
       this.equipos = equipos;
       this.listaGrupos = listaGrupos;
       this.eventoses = eventoses;
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
    public Usuarios getUsuariosByIdUsuariosDocente() {
        return this.usuariosByIdUsuariosDocente;
    }
    
    public void setUsuariosByIdUsuariosDocente(Usuarios usuariosByIdUsuariosDocente) {
        this.usuariosByIdUsuariosDocente = usuariosByIdUsuariosDocente;
    }
    public Usuarios getUsuariosByUsuariosIdUsuarios() {
        return this.usuariosByUsuariosIdUsuarios;
    }
    
    public void setUsuariosByUsuariosIdUsuarios(Usuarios usuariosByUsuariosIdUsuarios) {
        this.usuariosByUsuariosIdUsuarios = usuariosByUsuariosIdUsuarios;
    }
    public Set getEquipos() {
        return this.equipos;
    }
    
    public void setEquipos(Set equipos) {
        this.equipos = equipos;
    }
    public Set getListaGrupos() {
        return this.listaGrupos;
    }
    
    public void setListaGrupos(Set listaGrupos) {
        this.listaGrupos = listaGrupos;
    }
    public Set getEventoses() {
        return this.eventoses;
    }
    
    public void setEventoses(Set eventoses) {
        this.eventoses = eventoses;
    }




}


