package model;
// Generated 14/07/2018 10:59:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Emergencias generated by hbm2java
 */
public class Emergencias  implements java.io.Serializable {


     private int idEmergencias;
     private String nombre;
     private int telefono;
     private String correo;
     private Set historialEmergencias = new HashSet(0);

    public Emergencias() {
    }

	
    public Emergencias(int idEmergencias, String nombre, int telefono, String correo) {
        this.idEmergencias = idEmergencias;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Emergencias(int idEmergencias, String nombre, int telefono, String correo, Set historialEmergencias) {
       this.idEmergencias = idEmergencias;
       this.nombre = nombre;
       this.telefono = telefono;
       this.correo = correo;
       this.historialEmergencias = historialEmergencias;
    }
   
    public int getIdEmergencias() {
        return this.idEmergencias;
    }
    
    public void setIdEmergencias(int idEmergencias) {
        this.idEmergencias = idEmergencias;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Set getHistorialEmergencias() {
        return this.historialEmergencias;
    }
    
    public void setHistorialEmergencias(Set historialEmergencias) {
        this.historialEmergencias = historialEmergencias;
    }




}


