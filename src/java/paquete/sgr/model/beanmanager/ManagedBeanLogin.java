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
        
        // Crear list pair crea parametros que se envian a la consulta sin espacios
        consulta.crearListPair("user", user.trim() );
        consulta.crearListPair("pass", pass );
        List<Usuarios> u = consulta.crearSelectQuery("from Usuarios where login = :user and passsword = :pass");

        /* Si hay un usuario en la base de datos */
        if (!u.isEmpty()) {
            session = true;
            // Guardamos el IdUsuario en session en la sesión con el recuperaremos datos
            consulta.guardarDatosSession("UserId", u.get(0).getIdUsuarios());
            
            consulta.crearListPair("IdUsuario", consulta.obtenerDatosSesion("UserId"));
            // !!Se debe cambiar a un procedimiento almacenado
            List<DatosUsuario> du = consulta
                    .crearSelectQuery("FROM DatosUsuario as du where usuarios.idUsuarios = :IdUsuario ");
            if (!du.isEmpty()) {
                user = du.get(0).getNombre() + " " + du.get(0).getApellidoPaterno() + " " + du.get(0).getApellidoMaterno();
                consulta.guardarDatosSession("nombreUsuario", user);
            }
            /* Accedemos a los atributos del usuario que encontro */
            
            switch (u.get(0).getRoles().getIdRol()) {

                /* Numero 1 identifica administradores */
                case 1:
                    pagina = "Administrador/inicioAdministrador";
                    break;
                /* Numero 2 identifica docentes */
                case 2:
                    //No creado aún
                    break;
                /* Numero 3 identifica alumnos */
                case 3:
                    //No creado aún
                    break;
                /* Numero 4 identifica a tecnicos */
                case 4:
                     pagina = "ModuloAlumno/alumno";
                    break;
            }
            
        } else {
            message.MensajeError();
            return "index.xhtml";
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
