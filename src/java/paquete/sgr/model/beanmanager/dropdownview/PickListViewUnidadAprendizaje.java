package paquete.sgr.model.beanmanager.dropdownview;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import org.hibernate.Session;
import org.primefaces.model.DualListModel;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.UnidadGrupo;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.model.beanmanager.ManagedBeanGrupos;
import paquete.sgr.model.beanmanager.ManagedBeanUnidadGrupo;
import paquete.sgr.model.beanmanager.Mensajes;

/**
 *
 * @author iron1
 */
@Named(value = "pickListViewUnidadAprendizaje")
@RequestScoped
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

    }

    public void crearUnidadGrupo(int idGrupo) {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Grupo g = new Grupo();
        UnidadAprendizaje ua = new UnidadAprendizaje();
        UnidadGrupo ug;
        Usuarios uDocente = new Usuarios();
        Usuarios uTecnico = new Usuarios();

        g = (Grupo) s.load(Grupo.class, idGrupo);
        uDocente = (Usuarios) s.load(Usuarios.class, idDocente);
        uTecnico = (Usuarios) s.load(Usuarios.class, idtecnico);

        s.beginTransaction();
        try {
            for (UnidadAprendizaje item : UnidadAprendizaje.getTarget()) {
                ug = new UnidadGrupo();
                ug.setGrupo(g);
                ug.setUsuariosByIdUsuariosDocente(uDocente);
                ug.setUsuariosByUsuariosIdUsuarios(uTecnico);
                ug.setUnidadAprendizaje(item);
                s.save(ug);
                s.getTransaction().commit();
            }
            msj.setTitulo("Correcto");
            msj.setMensaje("Operación realizada");
            msj.MensajeInfo();
        } catch (Exception e) {
            s.getTransaction().rollback();
            msj.setTitulo("Error");
            msj.setMensaje("No se pudo completar la operación");
            msj.MensajeError();
        }

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
