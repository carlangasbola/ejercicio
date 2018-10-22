package paquete.sgr.model.beanmanager;

import java.io.IOException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.DatosUsuario;
import paquete.sgr.entity.pojos.Usuarios;

@Named(value = "managedBeanLogin")
@RequestScoped
public class ManagedBeanLogin {
    
    private String user;
    private String pass;
    // Cambiar a false para evitar el acceso a paginas sin login
    private boolean session = true;

    // Constructor por defecto
    public ManagedBeanLogin() {
    }
    
    public String validarUsuario() {
        String pagina = "";
        Mensajes message = new Mensajes("No estás registrado en la pagina", "Error");
        ConsultasHQL consulta = new ConsultasHQL();
        
        consulta.crearListPair("user", user);
        consulta.crearListPair("pass", pass);
        List<Usuarios> u = consulta.crearSelectQuery("from Usuarios where login = :user and passsword = :pass");

        /* Si hay un usuario en la base de datos */
        if (!u.isEmpty()) {
            session = true;
            // Guardamos el IdUsuario en la sesión con el recuperaremos datos
            consulta.guardarDatosSession("UserId", u.get(0).getIdUsuarios());
            
            consulta.crearListPair("IdUsuario", consulta.obtenerDatosSesion("UserId"));
            // !!Se debe cambiar a un procedimiento almacenado
            List<DatosUsuario> du = consulta
                    .crearSelectQuery("FROM DatosUsuario as du where usuarios.idUsuarios = :IdUsuario ");
            if (!du.isEmpty()) {
                user = du.get(0).getNombre() + " " + du.get(0).getApellidoPaterno() + " " + du.get(0).getApellidoMaterno();
            }
            /* Accedemos a los atributos del usuario que encontro */
            
            switch (u.get(0).getRoles().getIdRol()) {

                /* Numero 1 identifica docentes */
                case 1:
                    pagina = "ModuloAdministrador/administrador";
                    break;
                /* Numero 2 identifica administradores */
                case 2:
                    //No creado aún
                    break;
                /* Numero 3 identifica alumnos */
                case 3:
                    //No creado aún
                    break;
                /* Numero 4 identifica a tecnicos */
                case 4:
                    //No creado aún
                    break;
            }
            
        } else {
            message.MensajeError();
            return null;
        }
        
        return pagina;
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "../index.xhtml?faces-redirect=true";
    }

    //Permisos de acceso a la página
    public void permission() throws IOException {
        if (session == false) {
            System.out.println("*** The user has no permission to visit this page. *** ");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect("login.xhtml");
        } else {
            System.out.println("*** The session is still active. User is logged in. *** ");
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
    
}
