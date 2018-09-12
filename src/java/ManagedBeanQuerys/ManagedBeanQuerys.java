package ManagedBeanQuerys;

import Entity.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanQuerys")
@SessionScoped
public class ManagedBeanQuerys implements Serializable{

    /**
     * Creates a new instance of ManagedBeanQuerys
     */
    public ManagedBeanQuerys() {
    }
    
    private Session hibernateSession;
    
    
    /* Metodo generico que regresa cualquier tabla */
    public List<Object> getObjects( String  nameTabla ) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        // Concatena el nombre de la tabla con la sentencia FROM y devuelve los resultados
        String hql = "FROM " + nameTabla;
        Query query = hibernateSession.createQuery(hql);
        return query.list();    
    }
    
}
