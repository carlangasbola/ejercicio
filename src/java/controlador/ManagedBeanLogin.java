package controlador;

import Entity.HibernateUtil;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;

@Named(value = "managedBeanLogin")
@RequestScoped
public class ManagedBeanLogin {

    private String user;
    private String pass;
    private Session hibernateSession;
    
    public String validarUsuario() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession(); 
        Query query = hibernateSession.createQuery("from Usuarios where login = :user and passsword = :pass ");
        query.setParameter("user", user);
        query.setParameter("pass", pass);
        
        if ( !query.list().isEmpty() ) {
            System.out.println("HOla");
            hibernateSession.close();
            return "docente";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "!Error¡", "No estás registrado en el sistema intentalo de nuevo"));
            hibernateSession.close();
            return null;
        }
    }

    // Getters y setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    // Constructor por defecto
    public ManagedBeanLogin() {
    }

}
