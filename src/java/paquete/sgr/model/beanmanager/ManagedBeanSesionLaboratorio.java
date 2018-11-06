package paquete.sgr.model.beanmanager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.SesionDeLaboratorio;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.model.beanmanager.dropdownview.DropdownViewGrupoUnidades;

/**
 *
 * @author iron1
 */
@Named(value = "SesionLaboratorio")
@RequestScoped
public class ManagedBeanSesionLaboratorio {

    // Constructor
    public ManagedBeanSesionLaboratorio() {
    }

    private Date fechaSesison;
    private String idUnidadAprendizaje;
    private String idGrupo;
    private int idTecnico;
    private String docenteAuxiliar;

    @ManagedProperty(value = "#{DropdownViewGrupoUnidades}")
    private DropdownViewGrupoUnidades grupoUnidades;

    public String diaMaximo() {
        return "31/12/18";
    }

    public void crearSesionLaboratorio() {
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        SesionDeLaboratorio sl = new SesionDeLaboratorio();

        UnidadAprendizaje ua = (UnidadAprendizaje) s.load(UnidadAprendizaje.class, Integer.parseInt(grupoUnidades.getId_UnidadAprendizaje()));
        Grupo g = (Grupo) s.load(Grupo.class, Integer.parseInt(grupoUnidades.getId_Grupo()));
        Usuarios u = (Usuarios) s.load(Usuarios.class, idTecnico);

        sl.setFecha(fechaSesison);
        sl.setUnidadAprendizaje(ua);
        sl.setUsuarios(u);
        sl.setDocenteAuxiliar(docenteAuxiliar);
        sl.setGrupo(g);

        if (consulta.insertarObjeto(sl)) {
            msj.setTitulo("Exíto");
            msj.setMensaje("Evento creado exitosamente");
            msj.MensajeInfo();
        } else {
            msj.setTitulo("Error");
            msj.setMensaje("Ocurrio un error al procesar la solicitud");
            msj.MensajeError();
        }

    }

    /**
     * Getters and Setters
     *
     * @return  *
     */
    public Date getFechaSesison() {
        return fechaSesison;
    }

    public void setFechaSesison(Date fechaSesison) {
        this.fechaSesison = fechaSesison;
    }

    public String getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(String idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getDocenteAuxiliar() {
        return docenteAuxiliar;
    }

    public void setDocenteAuxiliar(String docenteAuxiliar) {
        this.docenteAuxiliar = docenteAuxiliar;
    }
    
    public DropdownViewGrupoUnidades getGrupoUnidades() {
        return grupoUnidades;
    }

    public void setGrupoUnidades(DropdownViewGrupoUnidades grupoUnidades) {
        this.grupoUnidades = grupoUnidades;
    }

}
