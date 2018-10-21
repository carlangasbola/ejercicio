package paquete.sgr.model.beanmanager;

import paquete.sgr.entity.util.HibernateUtil;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author iron1
 */
@Named(value = "Consultas")
@RequestScoped
public class ManagedBeanConsultas {

    private ArrayList<Pair<String, Object>> listPair;
    /**
     * Creates a new instance of ManagedBeanConsultas
     */
    public ManagedBeanConsultas() {
        listPair = new ArrayList<>();
    }
    
    // Añadir parametros a listPair
    public void crearListPair(String nombre, Object valor){
        listPair.add( new Pair<>(nombre,valor) );
    }
    
    public void vaciarListPair(){
       listPair.clear();
    }
    
    //Creación de parametros para la consulta
    public void creaParametro( Query query, Pair<String, Object> par ){
        query.setParameter(par.getKey(), par.getValue());
    }
    
    //Creacion del comando de consulta
    //Ejempplo consulta = from Usuarios where login = :user and passsword = :pass 
    public Query crearQuery(String consulta, ArrayList<Pair<String, Object>> valores ){
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query  = hibernateSession.createQuery(consulta);
        valores.forEach((par) -> {
            creaParametro(query,par);
        });
        return query;
    }
    
    //Getters y setters de listPair
    public ArrayList<Pair<String, Object>> getListPair() {
        return listPair;
    }

    public void setListPair(ArrayList<Pair<String, Object>> listPair) {
        this.listPair = listPair;
    }
    
    
}
