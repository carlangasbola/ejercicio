package paquete.sgr.model.beanmanager.dropdownview;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.SesionDeLaboratorio;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.model.beanmanager.ManagedBeanSesionLaboratorio;
import paquete.sgr.model.beanmanager.Mensajes;

@ManagedBean
@ViewScoped
public class DropdownViewGrupoUnidades implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String id_Grupo;
    private String id_UnidadAprendizaje;
    private Map<String, String> grupos;
    private Map<String, String> unidades_aprendizaje;

    @ManagedProperty(value = "#{SesionLaboratorio}")
    private ManagedBeanSesionLaboratorio sesionLaboratorio;

    @PostConstruct
    public void init() {
        /*La primer  propiedad es lo que se muestra (DEBE SER UNICO) */
        /*La segunda propiedad es el valor que tiene  */
        grupos = new HashMap<>();

        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        Map<String, String> map;
        Grupo grupo = new Grupo();
        Query query = s.createSQLQuery("CALL SelectGrupoUnidadAprendizaje()").addEntity(Grupo.class);
        List<Grupo> group = query.list();

        for (Grupo g : group) {
            
            this.grupos.put(g.getNombre(), g.getIdGrupo().toString());

            Query query2 = s.createSQLQuery("CALL SelectUnidadesAprendizajeGrupo(:id_Grupo)")
                    .addEntity(UnidadAprendizaje.class)
                    .setParameter("id_Grupo", g.getIdGrupo());

            List<UnidadAprendizaje> uas = query2.list();
            
            map = new HashMap<>();
            for (UnidadAprendizaje listua : uas) {             
                map.put(  listua.getNombre() ,  listua.getIdUnidadAprendizaje().toString() );
            }
            data.put(g.getIdGrupo().toString(), map);
        }

    }
    
    public void crearSesionLaboratorio() {
        
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        SesionDeLaboratorio sl = new SesionDeLaboratorio();

        UnidadAprendizaje ua = (UnidadAprendizaje) s.load(UnidadAprendizaje.class, Integer.parseInt( id_UnidadAprendizaje ));
        Grupo g = (Grupo) s.load(Grupo.class, Integer.parseInt(id_Grupo ));
        Usuarios u = (Usuarios) s.load(Usuarios.class, sesionLaboratorio.getIdTecnico());

        sl.setFecha(sesionLaboratorio.getFechaSesison());
        sl.setUnidadAprendizaje(ua);
        sl.setDocenteAuxiliar(sesionLaboratorio.getDocenteAuxiliar());
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

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getId_Grupo() {
        return id_Grupo;
    }

    public void setId_Grupo(String id_Grupo) {
        this.id_Grupo = id_Grupo;
    }

    public String getId_UnidadAprendizaje() {
        return id_UnidadAprendizaje;
    }

    public void setId_UnidadAprendizaje(String id_UnidadAprendizaje) {
        this.id_UnidadAprendizaje = id_UnidadAprendizaje;
    }

    public Map<String, String> getGrupos() {
        return grupos;
    }

    public Map<String, String> getUnidades_aprendizaje() {
        return unidades_aprendizaje;
    }
    
    public ManagedBeanSesionLaboratorio getSesionLaboratorio() {
        return sesionLaboratorio;
    }

    public void setSesionLaboratorio(ManagedBeanSesionLaboratorio SesionLaboratorio) {
        this.sesionLaboratorio = SesionLaboratorio;
    }
    

    public void onCountryChange() {
        if (id_Grupo != null && !id_Grupo.equals("")) {
            unidades_aprendizaje = data.get(id_Grupo);
        } else {
            unidades_aprendizaje = new HashMap<String, String>();
        }
    }

    public void displayLocation() {
        FacesMessage msg;
        if (id_UnidadAprendizaje != null && id_Grupo != null) {
            msg = new FacesMessage("Id_Unidad ", id_UnidadAprendizaje + " Id_Grupo " + id_Grupo);
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No has seleccionado grupo o unidad de aprendizaje.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
