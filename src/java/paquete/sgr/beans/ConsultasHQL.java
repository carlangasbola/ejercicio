package paquete.sgr.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import paquete.sgr.entity.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConsultasHQL {

    private ArrayList<Pair<String, Object>> listPair;
    private Map<String, Object> sessionMap;
    private ExternalContext externalContext;
    private Session hibernateSession;

    /**
     * Creates a new instance of ManagedBeanConsultas
     */
    public ConsultasHQL() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
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

    /**
     * 
     * @param consulta Consulta de tipo String como puede ser "FROM Usuarios"
     * @return Lista de tipo Object de resultados acorde la consulta enviada
     */
    public List crearSelectQuery(String consulta) {
        Session s = obtenerSession();
        Query query = s.createQuery(consulta);
        //Si no se le manda datos no hara nada
        if (!listPair.isEmpty()) {
            for (Pair<String, Object> par : listPair) {
                creaParametro(query, par);
            }
        }
        vaciarListPair();
        return query.list();
    }
    
    /**
     * 
     * @param o Objeto de la clase entity.pojos que va a actualizar
     */
    public void actualizarObjeto(Object o) {
        Session s = obtenerSession();
        Transaction tx = null;
        tx = s.beginTransaction();
        try {
            s.update(o);
            tx.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
            tx.rollback();
        }
    }
    
    public void insertarObjeto(Object o) {
        Session s = obtenerSession();
        Transaction tx = null;
        tx = s.beginTransaction();
        try {
            s.save(o);
            tx.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
            tx.rollback();
        }
    }
    
    public void eliminarObjeto(Object o) {
        Session s = obtenerSession();
        Transaction tx = null;
        tx = s.beginTransaction();
        try {
            s.delete(o);
            tx.commit();
        } catch (HibernateException ex) {
            System.err.println(ex);
            tx.rollback();
        }
    }

    // Si hay una session en hibernate la devuelve si no la crea
    public Session obtenerSession() {
        if (hibernateSession.isOpen()) {
            return hibernateSession;
        } else {
            return HibernateUtil.getSessionFactory().openSession();
        }
    }
    
    // El metodo finalize termina la conexion a la base de datos si no esta en uso
    @Override
    public void finalize() {
        if (hibernateSession.isOpen()) {
            hibernateSession.close();
        }
    }

// Guardar Datos en la sesión
    public void guardarDatosSession(String identificador, Object valor) {
        sessionMap.put(identificador, valor);
    }

    // Obtener datos de la sesion se regresa un object y se debe hacer un cast al dato que se desea utilizar
    public Object obtenerDatosSesion(String identificador) {
        return sessionMap.get(identificador);
    }

    /*******************************
        Getters y Setters Del Codigo
    *********************************/
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
