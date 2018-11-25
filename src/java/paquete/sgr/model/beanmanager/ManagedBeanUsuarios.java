package paquete.sgr.model.beanmanager;

import java.io.Serializable;
import java.util.ArrayList;
import paquete.sgr.entity.util.HibernateUtil;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import paquete.sgr.entity.pojos.DatosUsuario;
import paquete.sgr.entity.pojos.Roles;
import paquete.sgr.entity.pojos.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import paquete.sgr.beans.ConsultasHQL;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanQuerys")
@SessionScoped
public class ManagedBeanUsuarios implements Serializable {

    /**
     * Creates a new instance of ManagedBeanQuerys
     */
    public ManagedBeanUsuarios() {
        datosUsuarios = new ArrayList<>();
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
    private String passnew;
    private String passnew2;
    private int tipousuario;
    private int rol;
    private int idDatos;

    private List<DatosUsuario> datosUsuarios;
    private List<DatosUsuario> datosUsuariosFiltrados;

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    static String nombrecompleto;

    public String ObtenerNombreUsuario() {
        ConsultasHQL consulta = new ConsultasHQL();

        int id = (int) consulta.obtenerDatosSesion("UserId");

        consulta.crearListPair("idUsuario", id);
        List<DatosUsuario> du = consulta.crearSelectQuery("FROM DatosUsuario WHERE usuarios.idUsuarios = :idUsuario");

        nombrecompleto = du.get(0).getNombre() + " " + du.get(0).getApellidoPaterno() + " " + du.get(0).getApellidoMaterno();
        return "Administrador/creacionPractica1";
    }

    public String obtenerUsuarios() {
        /*
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("CALL SelectAllDatosUsuarios()").addEntity(DatosUsuario.class);
        datosUsuarios = query.list();
         */
        return "administracionUsuarios?faces-redirect=true";
    }

    public List obtenerUsuarios(int id) {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("CALL SelectDatosRol(:id)")
                .addEntity(DatosUsuario.class)
                .setParameter("id", id);
        return query.list();
    }

    public String obtenerDatosUsuario() {

        // Este codigo es para el f:params 
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        int userId;
        int id = Integer.parseInt(params.get("IdUsuario"));

        if (id == 0) {
            userId = getIdUsuarioSession();
        } else {
            userId = id;
        }

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
        return "modificacionDatos";
    }

    public void deleteUsuario(int id) {
        Mensajes msj = new Mensajes();
        ConsultasHQL cmd = new ConsultasHQL();
        hibernateSession = cmd.obtenerSession();
        try {
            hibernateSession.beginTransaction();
            Usuarios user = new Usuarios();
            user.setIdUsuarios(id);
            hibernateSession.delete(user);
            hibernateSession.getTransaction().commit();
            msj.setTitulo("Operación realizada");
            msj.setMensaje("Eliminado con éxito");
            msj.MensajeInfo();
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            msj.setTitulo("Operación no realizada");
            msj.setMensaje("Ocurrió un error intente más tarde");
            msj.MensajeError();
        }
    }

    public void actualizarContrasena() {
        ConsultasHQL consulta = new ConsultasHQL();
        Mensajes msj = new Mensajes();

        // Obtenemos el id del usuario 
        int idUsuario = (int) consulta.obtenerDatosSesion("UserId");
        consulta.crearListPair("UserId", idUsuario);
        List<Usuarios> u = consulta.crearSelectQuery(" FROM Usuarios where idUsuarios = :UserId");
        // Primero verificamos si la contraseña que ingreso es la misma que tiene registrada
        if (u.get(0).getPasssword().equals(password)) {
            if (passnew.equals(passnew2)) {
                Usuarios user = (Usuarios) u.get(0);
                user.setPasssword(passnew);
                consulta.actualizarObjeto(user);
                msj.setTitulo("Mensaje del sistema");
                msj.setMensaje("La contraseña se actualizó corectamente");
                msj.MensajeInfo();
            } else {
                msj.setTitulo("Mensaje del sistema");
                msj.setMensaje("Las contraseñas no coinciden");
                msj.MensajePrecaucion();
            }
        } else {
            msj.setTitulo("Mensaje del sistema");
            msj.setMensaje("Contraseña incorrecta");
            msj.MensajePrecaucion();
        }

    }

    public void actualizaUsuario() {
        Mensajes m = new Mensajes();
        Usuarios u = new Usuarios();
        DatosUsuario du = new DatosUsuario();
        ConsultasHQL consulta = new ConsultasHQL();

        Session hibernateSession = consulta.obtenerSession();
        Transaction tx = hibernateSession.beginTransaction();
        int userId = getIdUsuarioSession();
        consulta.crearListPair("userId", userId);
        List<DatosUsuario> dulist = consulta.crearSelectQuery("FROM DatosUsuario where usuarios.idUsuarios = :userId ");
        
         u = (Usuarios) hibernateSession.load(Usuarios.class, getIdUsuarioSession());

        if (password.equals(u.getPasssword())) {
            try {

                // Si no tiene datos de usuario
                if (dulist.isEmpty()) {
                    // Obtenemos la referencia a datos de usuario
                    du.setUsuarios(u);
                    du.setIdentificador(identificador);
                    du.setNombre(nombre);
                    du.setApellidoPaterno(paterno);
                    du.setApellidoMaterno(materno);
                    du.setTelefono(telefono);
                    du.setCorreo(correo);
                    du.setNumeroSeguro(numeroSeguro);
                    hibernateSession.save(du);
                    tx.commit();

                } else {
                    du.setIdUsuarios(u.getIdUsuarios());
                    du.setUsuarios(u);
                    du.setIdentificador(identificador);
                    du.setNombre(nombre);
                    du.setApellidoPaterno(paterno);
                    du.setApellidoMaterno(materno);
                    du.setTelefono(telefono);
                    du.setCorreo(correo);
                    du.setNumeroSeguro(numeroSeguro);
                    hibernateSession.update(du);
                    tx.commit();
                }

                m.setTitulo("!Correcto¡");
                m.setMensaje("Se actualizó tu información");
                m.MensajeInfo();

            } catch (Exception e) {
                tx.rollback();
                m.setTitulo("Fatal!");
                m.setMensaje("Ha ocurrido un error, inténtelo más tarde");
                m.MensajeFaltal();
                System.out.println("Exepcion : " + e);
            }
        } else {
            m.setTitulo("Error");
            m.setMensaje("La contraseña no es correcta");
            m.MensajePrecaucion();
        }

    }

    public void crearUsuario() {
        Mensajes m = new Mensajes();
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
            m.setTitulo("Infor");
            m.setMensaje("Agregado con éxito");
            m.MensajeInfo();
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            m.setTitulo("Error");
            m.setMensaje("No se completo la operación, intentelo más tarde");
            m.MensajeFaltal();
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

    public String getPassnew() {
        return passnew;
    }

    public void setPassnew(String passnew) {
        this.passnew = passnew;
    }

    public int getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(int idDatos) {
        this.idDatos = idDatos;
    }

    public String getPassnew2() {
        return passnew2;
    }

    public void setPassnew2(String passnew2) {
        this.passnew2 = passnew2;
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
