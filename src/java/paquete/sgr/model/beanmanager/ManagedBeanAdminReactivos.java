package paquete.sgr.model.beanmanager;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.entity.pojos.Reactivos;

/**
 *
 * @author César
 */

@Named(value = "managedBeanAdminReactivos")
@RequestScoped

public class ManagedBeanAdminReactivos {
    /*Crecion de variables para la recuperacion de datos*/
    private Session hibernateSession;
    private String nombrereactivo;
    private String tiporeactivo;
    private double cantidadreactivo;
    private byte existenciareactivo;
    private String medidareactivo;
    
    /* Obtener un solo reactivo */
    private Reactivos r;
    
    /*Obtener solo el nombre de los reactivos*/
    private List<String> listanombres;
    
    public void actualizarReactivo(int idreactivo) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Reactivos reactivo1 = new Reactivos();
        //Se recupera el grupo es como un select *from reactivos where idreactivos = idreactivo
        reactivo1.setIdReactivo(idreactivo);
        //se asignan los nuevos valores
        reactivo1.setNombre(nombrereactivo);
        reactivo1.setTipo(tiporeactivo);
        reactivo1.setCantidad(cantidadreactivo);
        reactivo1.setExistenciaInventario(existenciareactivo);
        reactivo1.setMedida(medidareactivo);
        //se hace el update
        hibernateSession.update(reactivo1);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
    
    public List<Reactivos> getReactivos() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from reactivos").addEntity(Reactivos.class);
        List<Reactivos> reactivos = query.list();
        return reactivos;
    }
    
    public List<String> NombresReactivos() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from reactivos").addEntity(Reactivos.class);
        List<Reactivos> reactivos = query.list();
        listanombres = new ArrayList<>();
        for(paquete.sgr.entity.pojos.Reactivos item:reactivos)
            listanombres.add(item.getNombre());
        
        return listanombres;
    }
    
    public void eliminarReactivo(int idreactivo) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Reactivos r = (Reactivos) s.load(Reactivos.class, idreactivo);
        consulta.eliminarObjeto(r);
    }
    
    public void crearReactivo() {
        Mensajes m = new Mensajes();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            hibernateSession.beginTransaction();
            Reactivos reactivo = new Reactivos();
            
            reactivo.setNombre(nombrereactivo);
            reactivo.setTipo(tiporeactivo);
            reactivo.setCantidad(cantidadreactivo);
            reactivo.setMedida(medidareactivo);
            reactivo.setExistenciaInventario(existenciareactivo);
            //Guardamos el reactivo en la base de datos
            hibernateSession.save(reactivo);
            hibernateSession.getTransaction().commit();
            m.setTitulo("Información");
            m.setMensaje("Reactivo agregado con éxito");
            m.MensajeInfo();
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            m.setTitulo("Fatal");
            m.setMensaje("Algo salio mal");
            m.MensajeFaltal();
            System.out.println("Exepcion : " + e);
        }
    }
    
    public String validarExistencia(byte existenciaInventario){
        if (existenciaInventario==1)
            return "Si";
        else
            return "No";
    }
    
    /*Getters y setters*/
    public String getNombrereactivo() {
        return nombrereactivo;
    }

    public void setNombrereactivo(String nombrereactivo) {
        this.nombrereactivo = nombrereactivo;
    }

    public String getTiporeactivo() {
        return tiporeactivo;
    }

    public void setTiporeactivo(String tiporeactivo) {
        this.tiporeactivo = tiporeactivo;
    }

    public double getCantidadreactivo() {
        return cantidadreactivo;
    }

    public void setCantidadreactivo(double cantidadreactivo) {
        this.cantidadreactivo = cantidadreactivo;
    }

    public byte getExistenciareactivo() {
        return existenciareactivo;
    }

    public void setExistenciareactivo(byte existenciareactivo) {
        this.existenciareactivo = existenciareactivo;
    }

    public String getMedidareactivo() {
        return medidareactivo;
    }

    public void setMedidareactivo(String medidareactivo) {
        this.medidareactivo = medidareactivo;
    }

    public Reactivos getR() {
        return r;
    }

    public void setR(Reactivos r) {
        this.r = r;
    }
    
}
