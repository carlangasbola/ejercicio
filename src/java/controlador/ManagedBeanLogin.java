package controlador;

import Entity.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import modelobase.DatosUsuario;
import modelobase.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;

@Named(value = "managedBeanLogin")
@RequestScoped
public class ManagedBeanLogin {

    private String user;
    private String pass;
    private Session hibernateSession;

    public String validarUsuario() {

        /* Con estas declaraciones guardaremos el id del usuario para interactuar en todas las páginas*/
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        String pagina = "";
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createQuery(" from Usuarios where login = :user and passsword = :pass ");
        query.setParameter("user", user);
        query.setParameter("pass", pass);
        List<Usuarios> u = query.list();
        Usuarios usuario = u.get(0);

        /* Si hay un usuario en la base de datos */
        if (!query.list().isEmpty()) {
            // Guardamos el IdUsuario en la sesión
            sessionMap.put("UserId", u.get(0).getIdUsuarios());
            /* Accedemos a los atributos del usuario que encontro */
            List<Usuarios> lista = query.list();
            DatosUsuario data = new DatosUsuario();
            this.user = usuario.getLogin();
            
            switch (lista.get(0).getRoles().getIdRol()) {

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
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "!Error¡", "No estás registrado en el sistema intentalo de nuevo"));
            hibernateSession.close();
            return null;
        }

        return pagina;
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
