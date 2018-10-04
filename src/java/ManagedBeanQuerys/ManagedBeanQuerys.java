package ManagedBeanQuerys;

import Entity.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelobase.DatosUsuario;
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
public class ManagedBeanQuerys {

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
    private String telefono;
    private String correo;
    private String password;
    private String numeroSeguro;
    private String identificador;
    private int tipousuario;
    private int rol;
    private int idDatos;

    public List obtenerUsuarios() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("CALL SelectAllDatosUsuarios()").addEntity(DatosUsuario.class);
        return query.list();
    }

    public void obtenerDatosUsuario() {

        int userId = getIdUsuarioSession();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery(
                "CALL SelectDatosUsuario(:idDatos_usuario)")
                .addEntity(DatosUsuario.class)
                .setParameter("idDatos_usuario", userId);

        List result = query.list();

        for (int i = 0; i < result.size(); i++) {
            DatosUsuario datos = (DatosUsuario) result.get(i);
            nombre = datos.getNombre();
            paterno = datos.getApellidoPaterno();
            materno = datos.getApellidoMaterno();
            telefono = datos.getTelefono();
            correo = datos.getCorreo();
            numeroSeguro = datos.getNumeroSeguro();
            identificador = datos.getIdentificador();

        }
    }

    public void deleteUsuario(int id) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        try {
            hibernateSession.beginTransaction();
            Usuarios user = new Usuarios();
            user.setIdUsuarios(id);
            hibernateSession.delete(user);
            hibernateSession.getTransaction().commit();
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Algo salio mal :v"));
            System.out.println("Exepcion : " + e);

        }
    }

    public void actualizaUsuario() {

        int userId = getIdUsuarioSession();

        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        DatosUsuario datos2 = new DatosUsuario();
        int idDatosUsuarios;

        Query query = hibernateSession.createSQLQuery(
                "CALL SelectDatoUsuario(:idDatos_usuario)")
                .addEntity(DatosUsuario.class)
                .setParameter("idDatos_usuario", userId);

        List result = query.list();
        if (!result.isEmpty()) {
            datos2 = (DatosUsuario) result.get(0);
            idDatosUsuarios = datos2.getIdDatosUsuario();
        }
        else
            idDatosUsuarios = userId;

        try {
            hibernateSession.beginTransaction();
            Usuarios user = new Usuarios();
            DatosUsuario data = new DatosUsuario();

            user.setIdUsuarios(userId);
            data.setUsuarios(user);
            data.setIdDatosUsuario(idDatosUsuarios);
            data.setIdentificador(identificador);
            data.setNombre(nombre);
            data.setApellidoMaterno(materno);
            data.setApellidoPaterno(paterno);
            data.setTelefono(telefono);
            data.setCorreo(correo);
            data.setNumeroSeguro(numeroSeguro);

            // Si existe en la base lo actualiza si no lo crea
            hibernateSession.clear();

            String hqlUpdate = "update Usuarios u set u.login = :login, u.passsword =:pass where u.idUsuarios = :idUsuarios";
            int updatedEntities = hibernateSession.createQuery(hqlUpdate)
                    .setString("login", correo)
                    .setString("pass", password)
                    .setInteger("idUsuarios", userId)
                    .executeUpdate();

            hibernateSession.saveOrUpdate(data);
            hibernateSession.flush();

            hibernateSession.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "!Correcto¡", "Se actualizó tu información"));

        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "Algo salio mal :v"));
            System.out.println("Exepcion : " + e);
        }
    }

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

    // Obtenemos el Id del usuario en sesión
    public int getIdUsuarioSession() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        return (int) sessionMap.get("UserId");
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getIdDatos_usuario() {
        return idDatos;
    }

    public void setIdDatos_usuario(int idDatos_usuario) {
        this.idDatos = idDatos_usuario;
    }

}
