package paquete.sgr.beans;

import paquete.sgr.entity.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;

public class ConsultasHQL {

    private ArrayList<Pair<String, Object>> listPair;
    private Map<String, Object> sessionMap;
    private ExternalContext externalContext;
    /**
     * Creates a new instance of ManagedBeanConsultas and listPair
     */
    public ConsultasHQL() {
        listPair = new ArrayList<>();
        externalContext = FacesContext.getCurrentInstance().getExternalContext();
        sessionMap = externalContext.getSessionMap();
    }

    // Añadir parametros a listPair
    public void crearListPair(String nombre, Object valor) {
        listPair.add(new Pair<>(nombre, valor));
    }

    // Vacia todo lo que tiene la lista para evitar que se llenen datos cuando este aun contine datos
    private void vaciarListPair() {
        listPair.clear();
    }

    //Creación de parametros para la consulta
    private void creaParametro(Query query, Pair<String, Object> par) {
        query.setParameter(par.getKey(), par.getValue());
    }

    //Creacion del comando de consulta
    //Ejempplo consulta = from Usuarios where login = :user and passsword = :pass 
    public List crearSelectQuery(String consulta) {
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createQuery(consulta);
        //Si no se le manda datos no hara nada
        if (!listPair.isEmpty()) {
            for( Pair<String, Object> par : listPair ){
                creaParametro(query,par);
            }      
        }
       vaciarListPair();
        return query.list();
    }
    
    // Guardar Datos en la sesión
    public void guardarDatosSession(String identificador, Object valor){
        sessionMap.put(identificador, valor);
    }
    
    // Obtener datos de la sesion se regresa un object y se debe hacer un cast al dato que se desea utilizar
    public Object obtenerDatosSesion(String identificador){
        return sessionMap.get(identificador);
    }

    /*
        Getters y Setters Del Codigo
     */
    //Getters y setters de listPair
    public ArrayList<Pair<String, Object>> getListPair() {
        return listPair;
    }

    public void setListPair(ArrayList<Pair<String, Object>> listPair) {
        this.listPair = listPair;
    }
    
    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ExternalContext getExternalContext() {
        return externalContext;
    }

    public void setExternalContext(ExternalContext externalContext) {
        this.externalContext = externalContext;
    }
}
