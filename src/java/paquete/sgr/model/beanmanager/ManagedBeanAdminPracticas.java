/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.Practicas;
import paquete.sgr.entity.pojos.Practica;
import paquete.sgr.entity.pojos.UnidadTematica;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.beans.*;
import paquete.sgr.entity.pojos.DatosPractica;
import paquete.sgr.entity.pojos.Equipo;
import paquete.sgr.entity.pojos.EquipoLaboratorio;
import paquete.sgr.entity.pojos.EquipoUtilizado;
import paquete.sgr.entity.pojos.ListaGrupo;
import paquete.sgr.entity.pojos.MaterialUtilizado;
import paquete.sgr.entity.pojos.Material;
import paquete.sgr.entity.pojos.Reactivos;
import paquete.sgr.entity.pojos.ReactivosUtilizadoPractica;
import paquete.sgr.entity.pojos.UnidadGrupo;
import paquete.sgr.entity.pojos.ReportePractica;

/**
 *
 * @author César
 */

@Named(value = "managedBeanAdminPracticas")
@RequestScoped
public class ManagedBeanAdminPracticas {
    /*Creacion de variables para la recuperacion de datos*/
    private Session hibernateSession;
    Practicas practica = new Practicas();
    private int idAuxiliar;
    private int idUnidadTematica;
    private List<UnidadGrupo> unidad;
    private List<UnidadTematica> unidadesTematicas;
    private Integer idGrupo;
    private Integer idUnidadGrupo;
    private Date fechaAsignacion;
    static int idUnidadAprendizaje;
    static Practica practicaAuxiliar;
    static List<UnidadGrupo> unidadAux;
    
    public List<Practica> getPracticas() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from practica").addEntity(Practica.class);
        List<Practica> practica = query.list();
        return practica;
    }
    public List<Usuarios> getUsuarios(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from usuarios where idUsuarios='"+id+"'").addEntity(Practica.class);
        List<Usuarios> usuarios = query.list();
        return usuarios;
    }
    
    public List<UnidadTematica> getUnidades(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from unidad_tematica where idUnidad_Tematica='" + id + "'").addEntity(UnidadTematica.class);
        List<UnidadTematica> unidades = query.list();
        return unidades;
    }
    
    public List<MaterialUtilizado> getMaterial(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from material_utilizado where idPractica='" + id + "'").addEntity(MaterialUtilizado.class);
        List<MaterialUtilizado> materialUtilizado = query.list();
        return materialUtilizado;
    }
    
    public List<EquipoUtilizado> getEquipo(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from equipo_utilizado where idPractica='" + id + "'").addEntity(EquipoUtilizado.class);
        List<EquipoUtilizado> equipoUtilizado = query.list();
        return equipoUtilizado;
    }
    
    public List<ReactivosUtilizadoPractica> getReactivos(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from reactivos_utilizado_practica where idPractica='" + id + "'").addEntity(ReactivosUtilizadoPractica.class);
        List<ReactivosUtilizadoPractica> reactivoUtilizado = query.list();
        return reactivoUtilizado;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Obtiene las unidades tematicas de las unidades de aprendizaje
    
    public String redireccionaEntrega(){
        
        
        return "subirReporte";
    }
    
    public List<ReportePractica> practicasPendientes(){
        ConsultasHQL consulta = new ConsultasHQL();
        List<ReportePractica> reportes;
        consulta.crearListPair("IdAlumno",  consulta.obtenerDatosSesion("UserId") );
        reportes = consulta.crearSelectQuery("FROM ReportePractica WHERE usuarios.idUsuarios = :IdAlumno");
        return  reportes;
    } 
    
    public int guardaIdUnidadAprendizaje(int id){
        idUnidadAprendizaje=id;
        return idUnidadAprendizaje;
    }
    public void guardaFechaEntregaPractica(){
        System.out.println("Este es el id del docente  " + getIdUsuarioSession());
        System.out.println("Este es el id Unidad de unidad aprendizaje " + idUnidadAprendizaje);
        System.out.println("Este es el id Unidad grupo " + idUnidadGrupo);
        System.out.println("Esta es la fecha " + fechaAsignacion);
        
        ConsultasHQL consulta = new ConsultasHQL();
        Session s=consulta.obtenerSession();
        consulta.crearListPair("idUnidadGrupo", idUnidadGrupo);
        List<ListaGrupo> alumnos = consulta.crearSelectQuery("FROM ListaGrupo where unidadGrupo.idUnidadGrupo = :idUnidadGrupo");
        
        
        for(ListaGrupo lgs:alumnos){
            Usuarios u = new Usuarios();
            System.out.println(lgs.getUsuarios().getIdUsuarios());
            ReportePractica rp = new ReportePractica();
            u=(Usuarios) s.get(Usuarios.class, lgs.getUsuarios().getIdUsuarios());
            rp.setUsuarios(u);
            rp.setFecha(fechaAsignacion);
            consulta.insertarObjeto(rp);
        }
        
    }
    public String asignaPractica(int idPractica, int idUnidadAprendizaje){
        //Inicio recuperación de la práctica
        List<Practica> practicas;
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("idPrac", idPractica);
        practicas = consulta.crearSelectQuery("FROM Practica where idPractica = :idPrac");
        practicaAuxiliar = practicas.get(0);
        //Fin recuperación de la práctica
        
        //Inicio recuperación de los grupos del docente
        consulta.crearListPair("idDocente", getIdUsuarioSession());
        consulta.crearListPair("idUnidad", idUnidadAprendizaje);
        unidad = consulta.crearSelectQuery("FROM UnidadGrupo where usuariosByIdUsuariosDocente.idUsuarios = :idDocente and unidadAprendizaje.idUnidadAprendizaje = :idUnidad");
        //Fin recuperación de los grupos del docente
        
        return "datosAsignacion";
    }
    
    //Obtiene los grupos, y unidades de aprendizaje del docente
    public String practicasDocente(){
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("idDocente", getIdUsuarioSession());
        unidad = consulta.crearSelectQuery("FROM UnidadGrupo where usuariosByIdUsuariosDocente.idUsuarios = :idDocente");
        idAuxiliar=getIdUsuarioSession();
        return "practicasDisponibles";
    }
    
    public List<UnidadGrupo> unidadesDisponibles(){
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("idDocente", getIdUsuarioSession());
        consulta.crearListPair("idUnidad", idUnidadAprendizaje);
        unidadAux=consulta.crearSelectQuery("FROM UnidadGrupo where usuariosByIdUsuariosDocente.idUsuarios = :idDocente and unidadAprendizaje.idUnidadAprendizaje = :idUnidad");
        return unidadAux;
        
    }
    
    public int getIdUsuarioSession() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        return (int) sessionMap.get("UserId");
    }
    
    public String asigna(int id){
        List<Practica> practicas;
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("idPrac", id);
        practicas = consulta.crearSelectQuery("FROM Practica where idPractica = :idPrac");
        practicaAuxiliar = practicas.get(0);
        idAuxiliar=id;
        return "datosPractica";
    }
    
    public List<UnidadTematica> getUnidadesT() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from unidad_tematica").addEntity(UnidadTematica.class);
        List<UnidadTematica> unidad = query.list();
        return unidad;
    }
    
    public int buscaIdPractica() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from practica").addEntity(Practica.class);
        List<Practica> p = query.list();
        System.out.println("numero de id"  + p.get(p.size()-1).getIdPractica());
        return p.get(p.size()-1).getIdPractica();
    }
    
    public int buscaNoDatos() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from datos_practica").addEntity(DatosPractica.class);
        List<DatosPractica> p = query.list();
        System.out.println("numero de id"  + (p.get(p.size()-1).getNumeroPractica())+(1));
        return 1;
    }
    
    public void eliminarPractica(int idpractica) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Practica r = (Practica) s.load(Practica.class, idpractica);
        consulta.eliminarObjeto(r);
    }
    
    public void crearPractica() {
        Mensajes m = new Mensajes();
        Date fecha = new Date();
        ConsultasHQL cmd  = new ConsultasHQL();
        hibernateSession = cmd.obtenerSession();
        
        try {
            hibernateSession.beginTransaction();
            Practica practica1 = new Practica();
            int id = (int) cmd.obtenerDatosSesion("UserId");
            Usuarios user = (Usuarios) hibernateSession.get(Usuarios.class, id );
            UnidadTematica unidad = (UnidadTematica)hibernateSession.get(UnidadTematica.class, idUnidadTematica);
            practica1.setCreacion(fecha);
            practica1.setUsuarios(user);
            practica1.setUnidadTematica(unidad);
            hibernateSession.save(practica1);
            
            DatosPractica datos = new DatosPractica();
            datos.setPractica(practica1);
            datos.setNumeroPractica(5);
            datos.setNombre(ManagedBeanPractica.practica.titulopractica);
            datos.setEditor("Editores");
            datos.setActualizacion(fecha);
            datos.setIntroducion(ManagedBeanPractica.practica.introduccion);
            datos.setActividadesPrevias(ManagedBeanPractica.practica.actividadesprevias);
            datos.setObjetivos(ManagedBeanPractica.practica.objetivos);
            datos.setSemaforo(ManagedBeanPractica.practica.semaforo);
            datos.setRecomendaciones(ManagedBeanPractica.practica.recomendaciones);
            datos.setProtocolos(ManagedBeanPractica.practica.protocolosdeactuacion);
            datos.setDesarrollo(ManagedBeanPractica.practica.desarrolloexperimental);
            datos.setRegistroDatos(ManagedBeanPractica.practica.registrodedatos);
            datos.setResultados(ManagedBeanPractica.practica.resultados);
            datos.setAnalisisResultados(ManagedBeanPractica.practica.analisisderesultados);
            datos.setReferencias(ManagedBeanPractica.practica.referencias);
            datos.setNomeclantura(ManagedBeanPractica.practica.nomenclatura);
            datos.setAnexos(ManagedBeanPractica.practica.anexos);
            hibernateSession.save(datos);
            
            ReactivosUtilizadoPractica r = new ReactivosUtilizadoPractica();
            
            for (Reactivo item:ManagedBeanReactivos.lista){
                Query query = 
                        hibernateSession.createQuery("FROM Reactivos WHERE nombre =:name")
                                .setParameter("name", item.getNombre());
                
                Reactivos reactivo = (Reactivos) query.uniqueResult();
                Reactivos reac = (Reactivos) hibernateSession.get(Reactivos.class,reactivo.getIdReactivo());
                r.setReactivos(reac);
            }
            r.setPractica(practica1);
            
            hibernateSession.save(r);
            
            MaterialUtilizado ma = new MaterialUtilizado();
            
            for (Materiales item:ManagedBeanMaterial.list){
                Query query = 
                        hibernateSession.createQuery("FROM Material WHERE nombre =:name")
                                .setParameter("name", item.getNombre());
                
                Material mat = (Material) query.uniqueResult();
                Material mate = (Material) hibernateSession.get(Material.class,mat.getIdMaterial());
                ma.setMaterial(mate);
            }
            ma.setPractica(practica1);
            hibernateSession.save(ma);
            
            EquipoUtilizado e = new EquipoUtilizado();
            
            for (Equipos item:ManagedBeanEquipo.lista){
                Query query = 
                        hibernateSession.createQuery("FROM EquipoLaboratorio WHERE nombre =:name")
                                .setParameter("name", item.getNombre());
                
                EquipoLaboratorio equipo = (EquipoLaboratorio) query.uniqueResult();
                EquipoLaboratorio eq = (EquipoLaboratorio) hibernateSession.get(EquipoLaboratorio.class,equipo.getIdEquipoLaboratorio());
                e.setEquipoLaboratorio(eq);
            }
            e.setPractica(practica1);
            hibernateSession.save(e);
            
            hibernateSession.getTransaction().commit();
            m.setTitulo("Información");
            m.setMensaje("Practica creada con éxito");
            m.MensajeInfo();
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            m.setTitulo("Fatal");
            m.setMensaje("Algo salio mal");
            m.MensajeFaltal();
            System.out.println("Exepcion : " + e);
        }
    }
    
    public int getIdAuxiliar() {
        return idAuxiliar;
    }
    
    public void setIdAuxiliar(int idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }
    
    public int getIdUnidadTematica() {
        return idUnidadTematica;
    }

    public void setIdUnidadTematica(int idUnidadTematica) {
        this.idUnidadTematica = idUnidadTematica;
    }

    public List<UnidadGrupo> getUnidad() {
        return unidad;
    }

    public void setUnidad(List<UnidadGrupo> unidad) {
        this.unidad = unidad;
    }

    public List<UnidadTematica> getUnidadesTematicas() {
        return unidadesTematicas;
    }

    public void setUnidadesTematicas(List<UnidadTematica> unidadesTematicas) {
        this.unidadesTematicas = unidadesTematicas;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdUnidadGrupo() {
        return idUnidadGrupo;
    }

    public void setIdUnidadGrupo(Integer idUnidadGrupo) {
        this.idUnidadGrupo = idUnidadGrupo;
    }
    
    

    public static int getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public static void setIdUnidadAprendizaje(int idUnidadAprendizaje) {
        ManagedBeanAdminPracticas.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public Practica getPracticaAuxiliar() {
        return practicaAuxiliar;
    }

    public void setPracticaAuxiliar(Practica practicaAuxiliar) {
        ManagedBeanAdminPracticas.practicaAuxiliar = practicaAuxiliar;
    }

    public List<UnidadGrupo> getUnidadAux() {
        return unidadAux;
    }

    public void setUnidadAux(List<UnidadGrupo> unidadAux) {
        ManagedBeanAdminPracticas.unidadAux = unidadAux;
    }
    
    
    
    

    
    
    
    
    
    
}
