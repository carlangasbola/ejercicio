package ManagedBeanGrupos;

import Entity.HibernateUtil;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import modelobase.Grupo;
import modelobase.UnidadAprendizaje;
import modelobase.Usuarios;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanGrupos")
@RequestScoped
public class ManagedBeanGrupos {

    /**
     * Creates a new instance of ManagedBeanGrupos
     */
    private Session hibernateSession;
    private String nombregrupo;
    private int cupogrupo;

    /*Creacion de unidades de aprendizaje*/
    private String  nombreunidad;
    private String docenteauxiliarunidad;
    private int grupo;
    private int docente;
    
    /*Parametros grupo*/
    
    
    public ManagedBeanGrupos() {
    }
    
    public void actualizarGrupo( int idgrupo ){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Grupo grupoO = new Grupo();
        //Se recupera el grupo es como un select *from grupo where idgrupo = idgrupo
        grupoO.setIdGrupo(idgrupo);
        //se asignan los nuevos valores
        grupoO.setNombre(nombregrupo);
        grupoO.setCupo(cupogrupo);
        //se hace el update
        hibernateSession.update(grupoO);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }

    public List<Object> getGrupos() {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Grupo";
        Query query = hibernateSession.createQuery(hql);
        List<Object> results = query.list();
        hibernateSession.close();
        return results;
        
    }
    
    public List<UnidadAprendizaje> getUnidadesA() {
        /*No regresa las unidades de aprendizaje*/
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        String hql = " FROM UnidadAprendizaje";
        Query query = hibernateSession.createQuery(hql);
        List<UnidadAprendizaje> results = query.list();
       /*Si cierro la conexion ya no funciona*/
        return results;
        
    }
    
    public List<Usuarios> getDocentes() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        /*AQUI DEBERIAMOS OBTENER EL NOMBRE DEL USUARIO DE LA TABLA DATOS DE USUARIOS
        PERO LO MANEJO ASI POR AHORA PARA FINES PRACTICOS*/
        /*
            Definir idrol
            1.- Docente
            2.- Administrador
            3.- Alumno
            4.- Tecnico
        */
        String hql = " FROM Usuarios where idrol=1";
        Query query = hibernateSession.createQuery(hql);
        List<Usuarios> results = query.list();
        hibernateSession.close();
        return results;
        
    }
    
    public void eliminarGrupo( int idgrupo ){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Grupo grupoO = new Grupo();
        // select *from grupo where idgrupo = idgrupo
        grupoO.setIdGrupo(idgrupo);
        hibernateSession.delete(grupoO);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
    
    public void eliminarUnidadA( int idunidad ){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        UnidadAprendizaje ua = new UnidadAprendizaje();
        ua.setIdUnidadAprendizaje(idunidad);
        hibernateSession.delete(ua);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
    
    
    public void crearGrupo(){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        Grupo grupoO = new Grupo(nombregrupo,cupogrupo);
        hibernateSession.save(grupoO);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
    }
    
    public void crearUnidaAprendizaje(){
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        /*Obtener el grupo y el usuario sus llaves foraneas*/
        Grupo group = new Grupo();
        Usuarios user = new Usuarios();
        
        group.setIdGrupo(grupo);
        user.setIdUsuarios(docente);
        
        /* Mandamos los parametros para la creación de la unidad */
        UnidadAprendizaje unidad = new UnidadAprendizaje(group,user,nombreunidad,docenteauxiliarunidad);
        
        //Guardamos la unidad
        hibernateSession.save(unidad);
        //Commit the transaction
        hibernateSession.getTransaction().commit();
        hibernateSession.close();
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

}
