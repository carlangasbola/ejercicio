package ManagedBeanQuerys;

import Entity.HibernateUtil;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import modelobase.UnidadAprendizaje;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanUnidadesAprendizaje")
@RequestScoped
public class ManagedBeanUnidadesAprendizaje {
    
     private Session hibernateSession;
    /**
     * Creates a new instance of ManagedBeanUnidadesAprendizaje
     */
    public ManagedBeanUnidadesAprendizaje() {
    }
    
    public List<UnidadAprendizaje> getUnidadesAprendizaje(){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM UnidadAprendizaje";
        Query query = hibernateSession.createQuery(hql);
        List<UnidadAprendizaje> results = query.list();
        hibernateSession.close();
        return results;
    }
    
    
    //Getters y Setters
}
