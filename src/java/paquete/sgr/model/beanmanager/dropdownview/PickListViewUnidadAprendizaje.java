package paquete.sgr.model.beanmanager.dropdownview;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import org.primefaces.model.DualListModel;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.model.beanmanager.ManagedBeanGrupos;
import paquete.sgr.model.beanmanager.ManagedBeanUnidadGrupo;

/**
 *
 * @author iron1
 */
@Named(value = "pickListViewUnidadAprendizaje")
@Dependent
public class PickListViewUnidadAprendizaje {

    private DualListModel<UnidadAprendizaje> UnidadAprendizaje;
    private int idGrupo;
    private int idDocente;
    private int idtecnico;

    @PostConstruct
    public void init() {
        ConsultasHQL consulta = new ConsultasHQL();
        List<UnidadAprendizaje> UnidadesAprendizajeSource = new ArrayList<>();
        List<UnidadAprendizaje> UnidadesAprendizajeTarget = new ArrayList<>();

        // Obtenemos las unidades de aprendizaje
        List<UnidadAprendizaje> uas = consulta.crearSelectQuery("FROM UnidadAprendizaje ");

        // Le asigna el objeto a la unidad de aprensizaje
        for (UnidadAprendizaje ua : uas) {
            UnidadesAprendizajeSource.add(ua);
        }
        
        UnidadAprendizaje = new DualListModel<>(UnidadesAprendizajeSource, UnidadesAprendizajeTarget);
        consulta.getHibernateSession().close();
    }
    
    public void crearUnidadGrupo(){
       
    }

    public DualListModel<UnidadAprendizaje> getUnidadAprendizaje() {
        return UnidadAprendizaje;
    }

    public void setUnidadAprendizaje(DualListModel<UnidadAprendizaje> UnidadAprendizaje) {
        this.UnidadAprendizaje = UnidadAprendizaje;
    }
       
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(int idtecnico) {
        this.idtecnico = idtecnico;
    }
}
