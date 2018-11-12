package paquete.sgr.model.beanmanager;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.hibernate.Session;
import paquete.sgr.beans.Material;
import org.primefaces.event.FlowEvent;


@Named(value = "managedBeanMaterial")
@SessionScoped
public class ManagedBeanMaterial implements Serializable {

   // Definicion de variables
    static List<Material> list;
    
    private String auxnombre;
    private int auxcantidad;
    
    // Constructor 
    public ManagedBeanMaterial() {
        list = new ArrayList<>();
    }
    
    // Agregar un nuevo material
    public void add(String nombre, int cantidad) {
        Material agrega = new Material(nombre, cantidad);
        list.add(agrega);
    }
    
    public void eliminar(int posicion) {
        list.remove(posicion);
    }
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public String enviarParam() {

        return "pagina2";
    }

    //Getters y Setters
    
    public static void setList(List<Material> list) {
        ManagedBeanMaterial.list = list;
    }

    public List<Material> getList() {
        return list;
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
