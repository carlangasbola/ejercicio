package ManagedBeanQuerys;

import Entity.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelobase.DatosUsuario;
import modelobase.Grupo;
import modelobase.Roles;
import modelobase.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanQuerys")
@RequestScoped
public class ManagedBeanQuerys implements Serializable {

    /**
     * Creates a new instance of ManagedBeanQuerys
     */
    public ManagedBeanQuerys() {
    }

    private Session hibernateSession;

    //Parametros para la creación de un usuario
    private String nombre;
    private String paterno;
    private String materno;
    private int telefono;
    private String correo;
    private String password;
    private String numeroSeguro;
    private int tipousuario;
    private int rol;

    public void crearUsuario() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            hibernateSession.beginTransaction();
            Usuarios user = new Usuarios();
            DatosUsuario datauser = new DatosUsuario();
            Roles roles = new Roles();

            // Obetener el rol
            roles.setIdRol(rol);
            //El login sera con el correo y la password dada
            user.setLogin(correo);
            user.setPasssword(password);
            user.setRoles(roles);
            //Guardamos el usuario en la base de datos
            hibernateSession.save(user);

            //Llenamos la tabala de datos de usuario
            datauser.setNombre(nombre);
            datauser.setApellidoPaterno(paterno);
            datauser.setApellidoMaterno(materno);
            datauser.setTelefono(telefono);
            datauser.setCorreo(correo);
            datauser.setNumeroSeguro(numeroSeguro);
            // Hacemos la relacion de los datos de usuario con la tabla usuario
            datauser.setUsuarios(user);
            //Guardamos los datos del usuario
            hibernateSession.save(datauser);
            hibernateSession.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Agregado con éxito"));
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Algo salio mal :v"));
            System.out.println("Exepcion : " + e);
        }

    }
    
    public List<DatosUsuario> obtenerDatos(){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("CALL PA_SelectDatosUsuario()").addEntity(DatosUsuario.class);
        List<DatosUsuario> datos =  query.list();
        return datos;
    }

    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public int getRol() {
        return rol;
    }

    /* Valores para crear un solo Usuario */
    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

}
