package paquete.sgr.model.beanmanager;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.UnidadGrupo;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanGrupos")
@RequestScoped
public class ManagedBeanGrupos implements Serializable{

    private String nombregrupo;
    private int cupogrupo;

    /*Creacion de unidades de aprendizaje*/
    private String nombreunidad;
    private String docenteauxiliarunidad;
    private int grupo;
    private int docente;

    /* Todos los alumnos que estan en un grupo */
    private List alumnosGrupo;
    /* Las unidades que tiene un grupo*/
    private List<UnidadAprendizaje> ua;
    /* Obtener un solo grupo */
    private Grupo g;

    public ManagedBeanGrupos() {
      
    }

    
    public List<Grupo> getGrupos() {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        Query query = s.createSQLQuery("CALL SelectGrupos()").addEntity(Grupo.class);
        List<Grupo> grupos = query.list();
        return grupos;
    }

    public String redirecionarGruposAlumnos(int IdG) {
        ConsultasHQL consulta = new ConsultasHQL();
        grupo = IdG;
        consulta.crearListPair("Id_Grupo", IdG);
        List<Object[]> lista = consulta.crearSelectStoreProcesure("CALL SelectAlumnosGrupo(:Id_Grupo)");
        alumnosGrupo = lista;
        return "GruposAlumnos";
    }

    public String redirecionarGrupoUnidadesAprendizaje(int IdG) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        consulta.removerDatosSesion("GrupoId");
        consulta.guardarDatosSession("GrupoId", IdG);
        Query query = s.createSQLQuery("CALL SelectUnidadesAprendizajeGrupo (:idGrupo)")
                .addEntity(UnidadAprendizaje.class)
                .setParameter("idGrupo", IdG);
        ua = query.list();
        informacionGrupo(IdG);
        return "modGrupoUnidadesAprendizaje";
    }

    public List<UnidadAprendizaje> getUnidadesA() {
        ConsultasHQL consulta = new ConsultasHQL();
        List<UnidadAprendizaje> results = consulta.crearSelectQuery("FROM UnidadAprendizaje");
        return results;
    }

    public List<Usuarios> getDocentes() {
        /*AQUI DEBERIAMOS OBTENER EL NOMBRE DEL USUARIO DE LA TABLA DATOS DE USUARIOS
        PERO LO MANEJO ASI POR AHORA PARA FINES PRACTICOS*/
        /*
            Definir idrol
            1.- Administrador
            2.- Docente
            3.- Tecnico
            4.- Alumno
         */
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("rol", 2);
        List<Usuarios> results = consulta.crearSelectQuery("FROM Usuarios where idrol = :rol");
        return results;
    }

    public void eliminarGrupo(int idgrupo) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Grupo g = (Grupo) s.load(Grupo.class, idgrupo);
        consulta.eliminarObjeto(g);
    }

    public void eliminarUnidadA(int idunidad) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        UnidadAprendizaje unidadA = (UnidadAprendizaje) s.load(UnidadAprendizaje.class, idunidad);
        consulta.eliminarObjeto(unidadA);
    }

    public void crearGrupo() {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Grupo grupoO = new Grupo(nombregrupo, cupogrupo);
        if (consulta.insertarObjeto(grupoO)) {
            msj.setTitulo("¡Operación exitosa!");
            msj.setMensaje("Grupo creado");
            msj.MensajeInfo();
        } else {
            msj.setTitulo("Ocurrió un error");
            msj.setMensaje("No se inserto el grupo, probablemente el nombre ya existe");
            msj.MensajePrecaucion();
        }
    }

    public void informacionGrupo(int id) {
        UnidadGrupo ug = new UnidadGrupo();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        g = (Grupo) s.load(Grupo.class, id);
    }

    /*Getters y setters*/
    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

    public int getCupogrupo() {
        return cupogrupo;
    }

    public void setCupogrupo(int cupogrupo) {
        this.cupogrupo = cupogrupo;
    }

    public String getNombreunidad() {
        return nombreunidad;
    }

    public void setNombreunidad(String nombreunidad) {
        this.nombreunidad = nombreunidad;
    }

    public String getDocenteauxiliarunidad() {
        return docenteauxiliarunidad;
    }

    public void setDocenteauxiliarunidad(String docenteauxiliarunidad) {
        this.docenteauxiliarunidad = docenteauxiliarunidad;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }

    public List getAlumnosGrupo() {
        return alumnosGrupo;
    }

    public void setAlumnosGrupo(List alumnosGrupo) {
        this.alumnosGrupo = alumnosGrupo;
    }

    public List<UnidadAprendizaje> getUa() {
        return ua;
    }

    public void setUa(List<UnidadAprendizaje> ua) {
        this.ua = ua;
    }

    public Grupo getG() {
        return g;
    }

    public void setG(Grupo g) {
        this.g = g;
    }

}
