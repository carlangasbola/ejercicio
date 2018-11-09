package paquete.sgr.model.beanmanager;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.entity.pojos.Material;

/**
 *
 * @author César
 */

@Named(value = "managedBeanAdminMateriales")
@RequestScoped

public class ManagedBeanAdminMateriales {
    /*Crecion de variables para la recuperacion de datos*/
    private Session hibernateSession;
    private String nombrematerial;
    private int cantidadmaterial;
    private byte existenciamaterial;
    
    /* Obtener un solo reactivo */
    private Material m;
    
    public void actualizarMaterial(int idmaterial) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Material material1 = new Material();
        //Se recupera el grupo es como un select *from material where idmaterial = idmaterial
        material1.setIdMaterial(idmaterial);
        //se asignan los nuevos valores
        material1.setNombre(nombrematerial);
        material1.setCantidad(cantidadmaterial);
        material1.setExistenciaInventario(existenciamaterial);
        //se hace el update
        hibernateSession.update(material1);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
    
    public List<Material> getMaterial() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from material").addEntity(Material.class);
        List<Material> materiales = query.list();
        return materiales;
    }
    
    public void eliminarMaterial(int idmaterial) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Material m = (Material) s.load(Material.class, idmaterial);
        consulta.eliminarObjeto(m);
    }
    
    public void crearMaterial() {
        Mensajes m = new Mensajes();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            hibernateSession.beginTransaction();
            Material material = new Material();
            
            material.setNombre(nombrematerial);
            material.setCantidad(cantidadmaterial);
            material.setExistenciaInventario(existenciamaterial);
            //Guardamos el material en la base de datos
            hibernateSession.save(material);
            hibernateSession.getTransaction().commit();
            m.setTitulo("Informacion");
            m.setMensaje("Material agregado con éxito");
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

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    public String getNombrematerial() {
        return nombrematerial;
    }

    public void setNombrematerial(String nombrematerial) {
        this.nombrematerial = nombrematerial;
    }

    public int getCantidadmaterial() {
        return cantidadmaterial;
    }

    public void setCantidadmaterial(int cantidadmaterial) {
        this.cantidadmaterial = cantidadmaterial;
    }

    public byte getExistenciamaterial() {
        return existenciamaterial;
    }

    public void setExistenciamaterial(byte existenciamaterial) {
        this.existenciamaterial = existenciamaterial;
    }

    public Material getM() {
        return m;
    }

    public void setM(Material m) {
        this.m = m;
    }
    
}
