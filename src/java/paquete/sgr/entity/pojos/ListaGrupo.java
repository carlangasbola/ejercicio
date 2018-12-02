package paquete.sgr.entity.pojos;
// Generated 1/12/2018 09:48:47 PM by Hibernate Tools 4.3.1



/**
 * ListaGrupo generated by hbm2java
 */
public class ListaGrupo  implements java.io.Serializable {


     private Integer idListaGrupo;
     private Equipo equipo;
     private UnidadGrupo unidadGrupo;
     private Usuarios usuarios;

    public ListaGrupo() {
    }

    public ListaGrupo(Equipo equipo, UnidadGrupo unidadGrupo, Usuarios usuarios) {
       this.equipo = equipo;
       this.unidadGrupo = unidadGrupo;
       this.usuarios = usuarios;
    }
   
    public Integer getIdListaGrupo() {
        return this.idListaGrupo;
    }
    
    public void setIdListaGrupo(Integer idListaGrupo) {
        this.idListaGrupo = idListaGrupo;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public UnidadGrupo getUnidadGrupo() {
        return this.unidadGrupo;
    }
    
    public void setUnidadGrupo(UnidadGrupo unidadGrupo) {
        this.unidadGrupo = unidadGrupo;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }




}


