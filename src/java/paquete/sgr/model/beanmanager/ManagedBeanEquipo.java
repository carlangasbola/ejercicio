package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import paquete.sgr.beans.Equipo;

@Named(value = "managedBeanEquipo")
@SessionScoped
public class ManagedBeanEquipo implements Serializable {
    
    // Definicion de variables
    static List<Equipo> lista;
    private String auxnombre;
    private int auxcantidad;
    /**
     * Creates a new instance of ManagedBeanEquipo
     */
    public ManagedBeanEquipo() {
        lista = new ArrayList<>();
    }
    
    // Agregar un nuevo equipo
    public void add(String nombre, int cantidad) {
        Equipo agrega = new Equipo(nombre, cantidad);
        lista.add(agrega);
    }
    
    public void eliminar(int posicion) {
        lista.remove(posicion);
    }
    
    // Getters y Setters
    public List<Equipo> getLista() {
        return lista;
    }

    public void setLista(List<Equipo> lista) {
        this.lista = lista;
    }

    public String getAuxnombre() {
        return auxnombre;
    }

    public void setAuxnombre(String auxnombre) {
        this.auxnombre = auxnombre;
    }

    public int getAuxcantidad() {
        return auxcantidad;
    }

    public void setAuxcantidad(int auxcantidad) {
        this.auxcantidad = auxcantidad;
    }
    
}
