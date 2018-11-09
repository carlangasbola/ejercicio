package paquete.sgr.model.beanmanager;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import paquete.sgr.beans.Material;
import org.primefaces.event.FlowEvent;


@Named(value = "managedBeanMaterial")
@SessionScoped
public class ManagedBeanMaterial implements Serializable {

   // Definicion de variables
    static List<Material> list;
    
    // Constructor 
    public ManagedBeanMaterial() {
        list = new ArrayList<>();
    }
    
    // Agregar un nuevo material
    public void add() {
        list.add(new Material());
    }
    
    // Remover un material
    public void remove(){
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Cuidado", "No existen valores para eliminar"));
        }
    }
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }

    public String enviarParam() {

        return "pagina2";
    }

    //Getters y Setters
    
    public List<Material> getList() {
        return list;
    }

}
