package paquete.sgr.model.beanmanager;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.entity.pojos.EquipoLaboratorio;

/**
 *
 * @author César
 */

@Named(value = "managedBeanAdminEquipo")
@RequestScoped

public class ManagedBeanAdminEquipo {
    /*Crecion de variables para la recuperacion de datos*/
    private Session hibernateSession;
    private String nombreequipo;
    private String caracteristicasequipo;
    private int cantidadequipo;
    private byte existenciaequipo;
    
    /* Obtener un solo equipo */
    private EquipoLaboratorio e;
    
    /*Obtener solo el nombre de los equipos*/
    private List<String> listanombres;
    
    
    public void actualizarEquipo(int idequipo) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        EquipoLaboratorio equipo1 = new EquipoLaboratorio();
        //Se recupera el grupo es como un select *from EquipoLaboratorio where idEquipoLaboratorio = idequipo
        equipo1.setIdEquipoLaboratorio(idequipo);
        //se asignan los nuevos valores
        equipo1.setNombre(nombreequipo);
        equipo1.setCaracteristicas(caracteristicasequipo);
        equipo1.setCantidad(cantidadequipo);
        equipo1.setExistenciaInventario(existenciaequipo);
        //se hace el update
        hibernateSession.update(equipo1);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
    
    public List<EquipoLaboratorio> getEquipoLaboratorio() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from equipo_laboratorio").addEntity(EquipoLaboratorio.class);
        List<EquipoLaboratorio> equipo = query.list();
        return equipo;
    }
    
    public List<String> NombresEquipo() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from equipo_laboratorio").addEntity(EquipoLaboratorio.class);
        List<EquipoLaboratorio> equipo = query.list();
        listanombres = new ArrayList<>();
        for(paquete.sgr.entity.pojos.EquipoLaboratorio item:equipo)
            listanombres.add(item.getNombre());
        
        return listanombres;
    }
    
    
    public void eliminarEquipo(int idequipo) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        EquipoLaboratorio e = (EquipoLaboratorio) s.load(EquipoLaboratorio.class, idequipo);
        consulta.eliminarObjeto(e);
    }
    
    public void crearEquipo() {
        Mensajes m = new Mensajes();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            hibernateSession.beginTransaction();
            EquipoLaboratorio equipo = new EquipoLaboratorio();
            
            equipo.setNombre(nombreequipo);
            equipo.setCaracteristicas(caracteristicasequipo);
            equipo.setCantidad(cantidadequipo);
            equipo.setExistenciaInventario(existenciaequipo);
            //Guardamos el reactivo en la base de datos
            hibernateSession.save(equipo);
            hibernateSession.getTransaction().commit();
            m.setTitulo("Información");
            m.setMensaje("Equipo agregado con éxito");
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

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    public String getNombreequipo() {
        return nombreequipo;
    }

    public void setNombreequipo(String nombreequipo) {
        this.nombreequipo = nombreequipo;
    }

    public String getCaracteristicasequipo() {
        return caracteristicasequipo;
    }

    public void setCaracteristicasequipo(String caracteristicasequipo) {
        this.caracteristicasequipo = caracteristicasequipo;
    }

    public byte getExistenciaequipo() {
        return existenciaequipo;
    }

    public void setExistenciaequipo(byte existenciaequipo) {
        this.existenciaequipo = existenciaequipo;
    }

    public EquipoLaboratorio getE() {
        return e;
    }

    public void setE(EquipoLaboratorio e) {
        this.e = e;
    }

    public int getCantidadequipo() {
        return cantidadequipo;
    }

    public void setCantidadequipo(int cantidadequipo) {
        this.cantidadequipo = cantidadequipo;
    }
    
}