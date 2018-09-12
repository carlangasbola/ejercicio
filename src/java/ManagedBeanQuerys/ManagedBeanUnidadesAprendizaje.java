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
        try{
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("CALL PA_SelectUnidadAprendizaje()").addEntity(UnidadAprendizaje.class);
        return  query.list();
        }catch(Exception  e){
            //Se muestra la exepción
            System.out.println( "Exepcion encontrada " +  e);
        }
        return null;
    }
    
    
    //Getters y Setters
}
