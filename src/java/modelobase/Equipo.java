package modelobase;
// Generated 26/08/2018 08:42:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Equipo generated by hbm2java
 */
public class Equipo  implements java.io.Serializable {


     private Integer idEquipo;
     private String nombre;
     private Set deudas = new HashSet(0);
     private Set vales = new HashSet(0);
     private Set listaGrupos = new HashSet(0);

    public Equipo() {
    }

	
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    public Equipo(String nombre, Set deudas, Set vales, Set listaGrupos) {
       this.nombre = nombre;
       this.deudas = deudas;
       this.vales = vales;
       this.listaGrupos = listaGrupos;
    }
   
    public Integer getIdEquipo() {
        return this.idEquipo;
    }
    
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getDeudas() {
        return this.deudas;
    }
    
    public void setDeudas(Set deudas) {
        this.deudas = deudas;
    }
    public Set getVales() {
        return this.vales;
    }
    
    public void setVales(Set vales) {
        this.vales = vales;
    }
    public Set getListaGrupos() {
        return this.listaGrupos;
    }
    
    public void setListaGrupos(Set listaGrupos) {
        this.listaGrupos = listaGrupos;
    }




}

