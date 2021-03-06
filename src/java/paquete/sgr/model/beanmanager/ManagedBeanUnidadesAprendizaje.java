package paquete.sgr.model.beanmanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import paquete.sgr.beans.UnidadesTematicas;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.UnidadTematica;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanUnidadesAprendizaje")
@SessionScoped
public class ManagedBeanUnidadesAprendizaje implements Serializable {

    private static List<UnidadesTematicas> unidadTematica;
    private int idGrupo;
    private int idDocente;
    private List lista;
    private String unidadA;
    private List<UnidadAprendizaje> ListaUnidadAprendizaje;

    public ManagedBeanUnidadesAprendizaje() {
        unidadTematica = new ArrayList<>();
    }

    public void enlargeList() {
        unidadTematica.add(new UnidadesTematicas());
    }

    // Remover un Equipo
    public void remove() {
        Mensajes msj = new Mensajes();
        if (unidadTematica.size() > 0) {
            unidadTematica.remove(unidadTematica.size() - 1);
        } else {
            msj.setTitulo("Error");
            msj.setMensaje("No existen valores para eliminar");
            msj.MensajePrecaucion();
        }
    }

    public void eliminarUnidadAprendizaje(int id) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        UnidadAprendizaje ua = new UnidadAprendizaje();
        ua = (UnidadAprendizaje) s.get(UnidadAprendizaje.class, id);
        consulta.eliminarObjeto(ua);
    }

    public void obtenertUnidadesTematicas(int id) {
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("id", id);
        lista = consulta.crearSelectStoreProcesure("CALL SelectUnidadesTematicas(:id)");
    }

    public void crearUnidad() {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Session session = consulta.getHibernateSession();
        //Creamos la unidad de aprendizaje y agregamos el nombre
        try {
            session.beginTransaction();
            UnidadAprendizaje ua = new UnidadAprendizaje();
            ua.setNombre(unidadA);
            session.save(ua);
            UnidadTematica ut;
            //Iteramos todas las unidades tematicas
            for (UnidadesTematicas u : unidadTematica) {
                ut = new UnidadTematica();
                ut.setNombre(u.getNombreunidad());
                ut.setUnidadAprendizaje(ua);
                //Creamos la unidad de aprendizaje con sus unidades tematicas
                session.save(ut);
            }

            session.getTransaction().commit();

            msj.setTitulo("Excelente");
            msj.setMensaje("Operación realizada con éxito");
            msj.MensajeInfo();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            msj.setTitulo("Error");
            msj.setMensaje("Problema contacte al administrador");
            msj.MensajeError();
        }
    }

    //Getters y Setters
    public List<UnidadesTematicas> getUnidadTematica() {
        return unidadTematica;
    }

    public static void setUnidadTematica(List<UnidadesTematicas> unidadTematica) {
        ManagedBeanUnidadesAprendizaje.unidadTematica = unidadTematica;
    }

    public String getUnidadA() {
        return unidadA;
    }

    public void setUnidadA(String unidadA) {
        this.unidadA = unidadA;
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

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public List<UnidadAprendizaje> getListaUnidadAprendizaje() {
        ConsultasHQL consulta = new ConsultasHQL();
        ListaUnidadAprendizaje = consulta.crearSelectQuery("FROM UnidadAprendizaje");
        return ListaUnidadAprendizaje;
    }

    public void setListaUnidadAprendizaje(List<UnidadAprendizaje> ListaUnidadAprendizaje) {
        this.ListaUnidadAprendizaje = ListaUnidadAprendizaje;
    }
}
