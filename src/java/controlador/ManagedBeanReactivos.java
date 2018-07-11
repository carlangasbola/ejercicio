package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Reactivos;


@Named(value = "managedBeanReactivos")
@SessionScoped
public class ManagedBeanReactivos implements Serializable {
    
    // Declaracion de variables
    private List<Reactivos> lista;
    private List<String> list;
    
    // Inicializa el array de los materiales
    @PostConstruct
    public void init(){
        /*Aqui haremos una consulta a la base y obtendremos los materiales */
        list = new ArrayList<>();
        list.add("Hidróxido de sodio");
        list.add("Metanol");
        list.add("Glicerina");
        list.add("Ácido clorhídrico");
        list.add("Etanol");
        list.add("Acetona");
        list.add("Agua");
    }
    
    public ManagedBeanReactivos() {
        lista = new ArrayList<>();
    }
    
    public void add() {
        lista.add(new Reactivos());
    }
    
    // Remover un Equipo
    public void remove(){
        if (lista.size() > 0) {
            lista.remove(lista.size() - 1);
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Cuidado", "No existen valores para eliminar"));
        }
    }
    
    // Getters y Setters
    public List<Reactivos> getLista() {
        return lista;
    }

    public void setLista(List<Reactivos> lista) {
        this.lista = lista;
    }
    
    public List<String> getList() {
        return list;
    }
    
    public void setList(List<String> list) {
        this.list = list;
    }
    
}
