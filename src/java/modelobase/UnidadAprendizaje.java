package modelobase;
// Generated 26/08/2018 08:42:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UnidadAprendizaje generated by hbm2java
 */
public class UnidadAprendizaje  implements java.io.Serializable {


     private Integer idUnidadAprendizaje;
     private Grupo grupo;
     private Usuarios usuarios;
     private String nombre;
     private String docenteAuxiliar;
     private Set sesionDeLaboratorios = new HashSet(0);
     private Set practicas = new HashSet(0);

    public UnidadAprendizaje() {
    }

	
    public UnidadAprendizaje(Grupo grupo, Usuarios usuarios, String nombre, String docenteAuxiliar) {
        this.grupo = grupo;
        this.usuarios = usuarios;
        this.nombre = nombre;
        this.docenteAuxiliar = docenteAuxiliar;
    }
    
    public UnidadAprendizaje(Grupo grupo, Usuarios usuarios, String nombre, String docenteAuxiliar, Set sesionDeLaboratorios, Set practicas) {
       this.grupo = grupo;
       this.usuarios = usuarios;
       this.nombre = nombre;
       this.docenteAuxiliar = docenteAuxiliar;
       this.sesionDeLaboratorios = sesionDeLaboratorios;
       this.practicas = practicas;
    }
   
    public Integer getIdUnidadAprendizaje() {
        return this.idUnidadAprendizaje;
    }
    
    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocenteAuxiliar() {
        return this.docenteAuxiliar;
    }
    
    public void setDocenteAuxiliar(String docenteAuxiliar) {
        this.docenteAuxiliar = docenteAuxiliar;
    }
    public Set getSesionDeLaboratorios() {
        return this.sesionDeLaboratorios;
    }
    
    public void setSesionDeLaboratorios(Set sesionDeLaboratorios) {
        this.sesionDeLaboratorios = sesionDeLaboratorios;
    }
    public Set getPracticas() {
        return this.practicas;
    }
    
    public void setPracticas(Set practicas) {
        this.practicas = practicas;
    }




}

