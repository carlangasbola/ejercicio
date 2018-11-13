package paquete.sgr.model.beanmanager.dropdownview;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.primefaces.model.DualListModel;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.UnidadAprendizaje;

/**
 *
 * @author iron1
 */
@Named(value = "pickListView")
public class PickListView {

    
    private DualListModel<UnidadAprendizaje> UnidadAprendizaje;

    @PostConstruct
    public void init() {
        ConsultasHQL consulta = new ConsultasHQL();
        List<UnidadAprendizaje> UnidadesAprendizajeSource = new ArrayList<>();
        List<UnidadAprendizaje> UnidadesAprendizajeTarget = new ArrayList<>();
        
        // Obtenemos las unidades de aprendizaje
        List<UnidadAprendizaje> uas = consulta.crearSelectQuery("FROM UnidadAprendizaje ");
        
        // Le asigna el objeto a la unidad de aprensizaje
        for( UnidadAprendizaje ua : uas ){
            UnidadesAprendizajeSource.add(ua);
        }
        
        UnidadAprendizaje = new DualListModel<>(UnidadesAprendizajeSource, UnidadesAprendizajeTarget);
    }
    
    

    public DualListModel<UnidadAprendizaje> getUnidadAprendizaje() {
        return UnidadAprendizaje;
    }

    public void setUnidadAprendizaje(DualListModel<UnidadAprendizaje> UnidadAprendizaje) {
        this.UnidadAprendizaje = UnidadAprendizaje;
    }

}
