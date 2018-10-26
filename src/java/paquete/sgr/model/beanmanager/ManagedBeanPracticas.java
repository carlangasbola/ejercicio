package paquete.sgr.model.beanmanager;

import paquete.sgr.entity.util.HibernateUtil;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import paquete.sgr.entity.pojos.Practica;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.Usuarios;
import org.hibernate.Session;


@Named(value = "managedBeanPracticas")
@RequestScoped
public class ManagedBeanPracticas {
    /**
     * Creates a new instance of ManagedBeanPracticas
     */
    private Session hibernateSession;
    private int idUA;
    private int idUT;
    
    private Date currentDate = new Date();
    
    //Inyeccion del managedBean que tiene los datos de la práctica
    @ManagedProperty(value="#{managedBeanPractica}")
    private ManagedBeanPractica managedBeanPractica;
    
    @ManagedProperty(value="#{ManagedBeanLogin}")
    private ManagedBeanLogin managedBeanLogin;
    
    //Constructor de la clase
    public ManagedBeanPracticas() {
    }
    
    //Creacion de la práctica
    public void crearPractica(){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        
        //Creo el objeto Unidad de Aprendizaje y Usuario
        UnidadAprendizaje ua = new UnidadAprendizaje();
        Usuarios user = new Usuarios();
        // Recupero la unidad de aprendizaje
        ua.setIdUnidadAprendizaje(idUA);
        ua.setIdUnidadTematica(idUT);
        // Recupero el id del creador (que es el usuario en turno)
        
        
        // Creo el objeto Practica
        Practica pa = new Practica();
        
        //Añado los valores al objeto
        pa.setCreacion(currentDate);
        
        
    }
    
    //Metodos getters y setters
    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
    
    public int getIdUA() {
        return idUA;
    }

    public void setIdUA(int idUA) {
        this.idUA = idUA;
    }
    
    public int getIdUT() {
        return idUT;
    }

    public void setIdUT(int idUA) {
        this.idUT = idUT;
    }
    
}
