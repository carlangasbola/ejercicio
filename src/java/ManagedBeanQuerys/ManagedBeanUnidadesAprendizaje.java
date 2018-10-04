package ManagedBeanQuerys;

import Entity.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.UnidadesTematicas;
import modelobase.UnidadAprendizaje;
import modelobase.UnidadTematica;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanUnidadesAprendizaje")
@SessionScoped
public class ManagedBeanUnidadesAprendizaje implements Serializable {

    private static List<UnidadesTematicas> unidadTematica;
    private String unidadA;

    public ManagedBeanUnidadesAprendizaje() {
        unidadTematica = new ArrayList<>();
    }

    public void enlargeList() {
        unidadTematica.add(new UnidadesTematicas());
    }

    // Remover un Equipo
    public void remove() {
        if (unidadTematica.size() > 0) {
            unidadTematica.remove(unidadTematica.size() - 1);
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Error", "No existen valores para eliminar"));
        }
    }

    public List<UnidadesTematicas> unidadesAprendizaje() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM UnidadAprendizaje";
        Query query = session.createQuery(hql);
        return query.list();
    }

    public void crearUnidad() {

        Session session = HibernateUtil.getSessionFactory().openSession();
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
                session.save(ut);
            }
            session.getTransaction().commit();

            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO,
                                    "Excelente", "Operación realizada con éxito"));

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Error", "Problema contacte al administrador"));
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
    

}
