package paquete.sgr.model.beanmanager.dropdownview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.UnidadGrupo;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.model.beanmanager.Mensajes;

/**
 *
 * @author iron1
 */
@ManagedBean
@ViewScoped
public class DatatableCheckBoxUnidadAprendizaje implements Serializable{

    private List<UnidadAprendizaje> UnidadAprendizaje;
    private List<UnidadAprendizaje> UnidadAprendizajeSeleccionada;
    private int idGrupo;
    private int idDocente;
    private int idtecnico;

    @PostConstruct
    public void init() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        UnidadAprendizaje = new ArrayList<>();
        // Obtenemos las unidades de aprendizaje
        UnidadAprendizaje = s.createQuery("FROM UnidadAprendizaje ").list(); 
    }

    public void crearUnidadGrupo() {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        int idGrupo = (int) consulta.obtenerDatosSesion("GrupoId") ;
        Session s = consulta.obtenerSession();
        Grupo g = new Grupo();
        UnidadAprendizaje ua = new UnidadAprendizaje();
        UnidadGrupo ug;
        Usuarios uDocente = new Usuarios();
        Usuarios uTecnico = new Usuarios();

        g = (Grupo) s.load(Grupo.class, idGrupo);
        uDocente = (Usuarios) s.load(Usuarios.class, idDocente);
        uTecnico = (Usuarios) s.load(Usuarios.class, idtecnico);
        
        try {
            s.beginTransaction();
            for (UnidadAprendizaje item : UnidadAprendizajeSeleccionada) {
                ug = new UnidadGrupo();
                ug.setGrupo(g);
                ug.setUsuariosByIdUsuariosDocente(uDocente);
                ug.setUsuariosByUsuariosIdUsuarios(uTecnico);
                ug.setUnidadAprendizaje(item);
                s.save(ug);
            }
            s.getTransaction().commit();
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
    
    public List<UnidadAprendizaje> getUnidadAprendizaje() {
        return UnidadAprendizaje;
    }

    public void setUnidadAprendizaje(List<UnidadAprendizaje> UnidadAprendizaje) {
        this.UnidadAprendizaje = UnidadAprendizaje;
    }

    public List<UnidadAprendizaje> getUnidadAprendizajeSeleccionada() {
        return UnidadAprendizajeSeleccionada;
    }

    public void setUnidadAprendizajeSeleccionada(List<UnidadAprendizaje> UnidadAprendizajeSeleccionada) {
        this.UnidadAprendizajeSeleccionada = UnidadAprendizajeSeleccionada;
    }
}
