package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.ReporteIncidencia;
import paquete.sgr.entity.pojos.SesionDeLaboratorio;

/**
 *
 * @author iron1
 */
@Named(value = "Incidencias")
@RequestScoped
public class ManagedBeanIncidencias {

    private List<SesionDeLaboratorio> sesion;
    private List<ReporteIncidencia> reporteIncidencia;
    // Datos de reporte de incidencias 
    private String nombre;
    private String observaciones;
    private int idSesionLab;
    private String estado;
    private int idReporte;

    private ReporteIncidencia reporte;

    public ManagedBeanIncidencias() {
    }

    public String obtenerReporte(int id) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        ReporteIncidencia ri = new ReporteIncidencia();
        ri = (ReporteIncidencia) s.load(ReporteIncidencia.class, id);

        nombre = ri.getNombre();
        observaciones = ri.getObservaciones();

        consulta.removerDatosSesion("reporteId");
        consulta.guardarDatosSession("reporteId", id);
        return "actualizarReporteIncidencia";
    }

    public String verReporte(int id) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        ReporteIncidencia ri = new ReporteIncidencia();
        ri = (ReporteIncidencia) s.load(ReporteIncidencia.class, id);
        
        reporte = ri;
        
        nombre = ri.getNombre();
        observaciones = ri.getObservaciones();
        ri.getSesionDeLaboratorio().getFecha();
        ri.getSesionDeLaboratorio().getUnidadAprendizaje().getNombre();

        consulta.removerDatosSesion("reporteId");
        consulta.guardarDatosSession("reporteId", id);
        return "verIncidencia";
    }

    public List<ReporteIncidencia> obtenerReportes() {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        Query q = s.createQuery("FROM ReporteIncidencia");
        reporteIncidencia = q.list();
        return reporteIncidencia;
    }

    public void eliminarReporte(int id) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        Query q = s.createQuery("DELETE ReporteIncidencia WHERE idReporte = :idrepor").setParameter("idrepor", id);
        q.executeUpdate();
    }

    public List<SesionDeLaboratorio> obtenerSesiones() {
        ConsultasHQL consulta = new ConsultasHQL();
        sesion = new ArrayList<>();
        Session s = consulta.obtenerSession();
        Query q = s.createQuery("FROM SesionDeLaboratorio");
        sesion = q.list();
        return sesion;
    }

    public void actualizarReporte() {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        SesionDeLaboratorio sl = new SesionDeLaboratorio();
        Date now = new Date();
        Session s = consulta.obtenerSession();
        ReporteIncidencia ri = new ReporteIncidencia();

        int id = (int) consulta.obtenerDatosSesion("reporteId");
        ri = (ReporteIncidencia) s.load(ReporteIncidencia.class, id);
        sl = (SesionDeLaboratorio) s.load(SesionDeLaboratorio.class, idSesionLab);

        try {
            s.beginTransaction();
            ri.setIdReporte(id);
            ri.setSesionDeLaboratorio(sl);
            ri.setNombre(nombre);
            ri.setObservaciones(observaciones);
            ri.setFecha(ri.getFecha());
            ri.setEstado(estado);
            ri.setActualizacion(now);
            s.update(ri);
            s.getTransaction().commit();
            msj.setTitulo("Correcto");
            msj.setMensaje("Reporte actualizado");
            msj.MensajeInfo();
        } catch (Exception e) {
            s.getTransaction().rollback();
            msj.setTitulo("Error");
            msj.setMensaje("Ocurrió un problema inténtelo más tarde");
            msj.MensajeError();
        }
    }

    public void guardarReporteIncidencia() {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        SesionDeLaboratorio sl = new SesionDeLaboratorio();
        Date now = new Date();
        Session s = consulta.obtenerSession();
        ReporteIncidencia ri = new ReporteIncidencia();

        sl = (SesionDeLaboratorio) s.load(SesionDeLaboratorio.class, idSesionLab);

        try {

            s.beginTransaction();
            ri.setSesionDeLaboratorio(sl);
            ri.setNombre(nombre);
            ri.setObservaciones(observaciones);
            ri.setFecha(now);
            ri.setEstado("Abierto");
            ri.setActualizacion(now);
            s.save(ri);
            s.getTransaction().commit();
            msj.setTitulo("Correcto");
            msj.setMensaje("Reporte creado");
            msj.MensajeInfo();
        } catch (Exception e) {
            s.getTransaction().rollback();
            msj.setTitulo("Error");
            msj.setMensaje("Ocurrió un problema inténtelo más tarde");
            msj.MensajeError();
        }

    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<SesionDeLaboratorio> getSesion() {
        return sesion;
    }

    public void setSesion(List<SesionDeLaboratorio> sesion) {
        this.sesion = sesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public int getIdSesionLab() {
        return idSesionLab;
    }

    public void setIdSesionLab(int idSesionLab) {
        this.idSesionLab = idSesionLab;
    }

    public List<ReporteIncidencia> getReporteIncidencia() {
        return reporteIncidencia;
    }

    public void setReporteIncidencia(List<ReporteIncidencia> reporteIncidencia) {
        this.reporteIncidencia = reporteIncidencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public ReporteIncidencia getReporte() {
        return reporte;
    }

    public void setReporte(ReporteIncidencia reporte) {
        this.reporte = reporte;
    }

}
