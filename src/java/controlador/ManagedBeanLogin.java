package controlador;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "managedBeanLogin")
@RequestScoped
public class ManagedBeanLogin {

    private String user;
    private String pass;

    public String validarUsuario() {
        if (user.equals("carlos") && pass.equals("hola")) {
            System.out.println("HOla");
            return "docente";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
                    "!Error¡", "No estás registrado en el sistema intentalo de nuevo"));
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
