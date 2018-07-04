package paquete1;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

@Named(value = "managedBean")
@RequestScoped
public class ManagedBean {

    //Definicion de variales
    private DualListModel<String> sustancias;
    private int numeropractica;
    private String titulopractica;
    private String competencias;
    private String semestre;
    private String creador;

    // Constructor por defecto
    public void Managedbean() {
    }

    // Valores iniciados antes del constructor
    @PostConstruct
    public void init() {
        //Sustancias
        List<String> sustanciasSource = new ArrayList<>();
        List<String> sustanciasTarget = new ArrayList<>();

        sustanciasSource.add("Acido clorhidrico");
        sustanciasSource.add("Hidroxido de sodio");
        sustanciasSource.add("Glicerina");
        sustanciasSource.add("Metanol");
        sustanciasSource.add("Etanol");
        sustanciasSource.add("Acetona");

        sustancias = new DualListModel<>(sustanciasSource, sustanciasTarget);
    }

    public String enviarParam() {

        for (String str : sustancias.getTarget()) {
            System.out.println(" Materiales " + str);
        }

        return "pagina2";
    }

    //Getters y Setters
    public DualListModel<String> getSustancias() {
        return sustancias;
    }

    public void setSustancias(DualListModel<String> sustancias) {
        this.sustancias = sustancias;
    }

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

}
