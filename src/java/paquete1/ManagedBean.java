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
    
    private DualListModel<String> sustancias;
    
    // Constructor por defecto
    public void Managedbean(){
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
        
        sustancias = new DualListModel<>(sustanciasSource,sustanciasTarget);
    }
    
    public String enviarParam(){
        
        for (String str: sustancias.getTarget()){
            System.out.println(" SDASDJASJDA SDASDA DSADAS " + str );
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
    
   
}
