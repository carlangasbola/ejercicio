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

    /**
     * Creates a new instance of ManagedBeanEquipo
     */
    public ManagedBeanEquipo() {
        lista = new ArrayList<>();
    }
    
    public void add() {
        lista.add(new Equipo());
    }
    
    // Remover un Equipo
    public void remove(){
        if (lista.size() > 0) {
            lista.remove(lista.size() - 1);
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Error", "No existen valores para eliminar"));
        }
    }
    
    // Definicion de variables
    private List<Equipo> lista;
    
    // Getters y Setters
    public List<Equipo> getLista() {
        return lista;
    }

    public void setLista(List<Equipo> lista) {
        this.lista = lista;
    }
    
    
    
    
    
}
