package modelobase;
// Generated 3/10/2018 11:18:56 PM by Hibernate Tools 4.3.1



/**
 * ListaGrupo generated by hbm2java
 */
public class ListaGrupo  implements java.io.Serializable {


     private Integer idListaGrupo;
     private Equipo equipo;
     private Grupo grupo;
     private Usuarios usuarios;

    public ListaGrupo() {
    }

    public ListaGrupo(Equipo equipo, Grupo grupo, Usuarios usuarios) {
       this.equipo = equipo;
       this.grupo = grupo;
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




}


