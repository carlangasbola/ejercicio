package paquete.sgr.entity.pojos;
// Generated 16/11/2018 11:10:37 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UnidadTematica generated by hbm2java
 */
public class UnidadTematica  implements java.io.Serializable {


     private Integer idUnidadTematica;
     private UnidadAprendizaje unidadAprendizaje;
     private String nombre;
     private Set practicas = new HashSet(0);

    public UnidadTematica() {
    }

	
    public UnidadTematica(UnidadAprendizaje unidadAprendizaje, String nombre) {
        this.unidadAprendizaje = unidadAprendizaje;
        this.nombre = nombre;
    }
    public UnidadTematica(UnidadAprendizaje unidadAprendizaje, String nombre, Set practicas) {
       this.unidadAprendizaje = unidadAprendizaje;
       this.nombre = nombre;
       this.practicas = practicas;
    }
   
    public Integer getIdUnidadTematica() {
        return this.idUnidadTematica;
    }
    
    public void setIdUnidadTematica(Integer idUnidadTematica) {
        this.idUnidadTematica = idUnidadTematica;
    }
    public UnidadAprendizaje getUnidadAprendizaje() {
        return this.unidadAprendizaje;
    }
    
    public void setUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getPracticas() {
        return this.practicas;
    }
    
    public void setPracticas(Set practicas) {
        this.practicas = practicas;
    }




}


