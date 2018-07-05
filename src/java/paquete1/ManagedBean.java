package paquete1;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "managedBean")
@SessionScoped
public class ManagedBean implements Serializable {

    //Definicion de variales
    private int numeropractica;
    private String titulopractica;
    private String competencias;
    private String semestre;
    private String creador;
    private final List<paquete1.Item> list;

    // Constructor 
    public ManagedBean() {
        list = new ArrayList<>();
    }

    public void add() {
        list.add(new Item());
    }
    
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

    public String enviarParam() {

        return "pagina2";
    }

    //Getters y Setters
    
    public int getNumeropractica() {
        return numeropractica;
    }

    public void setNumeropractica(int numeropractica) {
        this.numeropractica = numeropractica;
    }

    public String getTitulopractica() {
        return titulopractica;
    }

    public void setTitulopractica(String titulopractica) {
        this.titulopractica = titulopractica;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
    
    public List<Item> getList() {
        return list;
    }

}
