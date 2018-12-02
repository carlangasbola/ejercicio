package paquete.sgr.entity.pojos;
// Generated 1/12/2018 09:48:47 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private Integer idUsuarios;
     private Roles roles;
     private String login;
     private String passsword;
     private Set reportePracticas = new HashSet(0);
     private Set practicas = new HashSet(0);
     private Set unidadGruposForIdUsuariosDocente = new HashSet(0);
     private Set listaGrupos = new HashSet(0);
     private Set unidadGruposForUsuariosIdUsuarios = new HashSet(0);
     private DatosUsuario datosUsuario;

    public Usuarios() {
    }

	
    public Usuarios(Roles roles) {
        this.roles = roles;
    }
    public Usuarios(Roles roles, String login, String passsword, Set reportePracticas, Set practicas, Set unidadGruposForIdUsuariosDocente, Set listaGrupos, Set unidadGruposForUsuariosIdUsuarios, DatosUsuario datosUsuario) {
       this.roles = roles;
       this.login = login;
       this.passsword = passsword;
       this.reportePracticas = reportePracticas;
       this.practicas = practicas;
       this.unidadGruposForIdUsuariosDocente = unidadGruposForIdUsuariosDocente;
       this.listaGrupos = listaGrupos;
       this.unidadGruposForUsuariosIdUsuarios = unidadGruposForUsuariosIdUsuarios;
       this.datosUsuario = datosUsuario;
    }
   
    public Integer getIdUsuarios() {
        return this.idUsuarios;
    }
    
    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPasssword() {
        return this.passsword;
    }
    
    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }
    public Set getReportePracticas() {
        return this.reportePracticas;
    }
    
    public void setReportePracticas(Set reportePracticas) {
        this.reportePracticas = reportePracticas;
    }
    public Set getPracticas() {
        return this.practicas;
    }
    
    public void setPracticas(Set practicas) {
        this.practicas = practicas;
    }
    public Set getUnidadGruposForIdUsuariosDocente() {
        return this.unidadGruposForIdUsuariosDocente;
    }
    
    public void setUnidadGruposForIdUsuariosDocente(Set unidadGruposForIdUsuariosDocente) {
        this.unidadGruposForIdUsuariosDocente = unidadGruposForIdUsuariosDocente;
    }
    public Set getListaGrupos() {
        return this.listaGrupos;
    }
    
    public void setListaGrupos(Set listaGrupos) {
        this.listaGrupos = listaGrupos;
    }
    public Set getUnidadGruposForUsuariosIdUsuarios() {
        return this.unidadGruposForUsuariosIdUsuarios;
    }
    
    public void setUnidadGruposForUsuariosIdUsuarios(Set unidadGruposForUsuariosIdUsuarios) {
        this.unidadGruposForUsuariosIdUsuarios = unidadGruposForUsuariosIdUsuarios;
    }
    public DatosUsuario getDatosUsuario() {
        return this.datosUsuario;
    }
    
    public void setDatosUsuario(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }




}


