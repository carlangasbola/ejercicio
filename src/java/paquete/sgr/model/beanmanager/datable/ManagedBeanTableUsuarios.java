package paquete.sgr.model.beanmanager.datable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.DatosUsuario;
import paquete.sgr.entity.util.HibernateUtil;

/**
 *
 * @author iron1
 */
@Named(value = "TableUsuarios")
@ViewScoped
public class ManagedBeanTableUsuarios implements Serializable{
    
    private List<DatosUsuario> datosUsuarios;
    private List<DatosUsuario> datosUsuariosFiltrados;
    
    public ManagedBeanTableUsuarios(){
    }
    
    @PostConstruct
    public void init() {
        reload();
    }
    
    public void reload(){
        datosUsuarios = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        datosUsuarios = s.createQuery("FROM DatosUsuario").list();
    }
    
    public List<DatosUsuario> getDatosUsuarios() {
        return datosUsuarios;
    }

    public void setDatosUsuarios(List<DatosUsuario> datosUsuarios) {
        this.datosUsuarios = datosUsuarios;
    }

    public List<DatosUsuario> getDatosUsuariosFiltrados() {
        return datosUsuariosFiltrados;
    }

    public void setDatosUsuariosFiltrados(List<DatosUsuario> datosUsuariosFiltrados) {
        this.datosUsuariosFiltrados = datosUsuariosFiltrados;
    }
    
}
