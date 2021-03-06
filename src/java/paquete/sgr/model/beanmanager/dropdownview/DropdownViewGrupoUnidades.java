package paquete.sgr.model.beanmanager.dropdownview;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.Eventos;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.NotificacionesSesion;
import paquete.sgr.entity.pojos.SesionDeLaboratorio;
import paquete.sgr.entity.pojos.UnidadAprendizaje;
import paquete.sgr.entity.pojos.UnidadGrupo;
import paquete.sgr.model.beanmanager.ManagedBeanSesionLaboratorio;
import paquete.sgr.model.beanmanager.Mensajes;

@ManagedBean
@ViewScoped
public class DropdownViewGrupoUnidades implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    public static String id_Grupo;
    public static String id_UnidadAprendizaje;
    private Map<String, String> grupos;
    private Map<String, String> unidades_aprendizaje;
    
   // Datos de evento
    private String tipo;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int idUnidadGrupo;

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
    
    public void crearEvento(){
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Eventos e = new Eventos();
        
        // Este se pone manualmente
        Grupo g = (Grupo) s.load(Grupo.class, 1);
        UnidadGrupo ug = (UnidadGrupo) s.load(UnidadGrupo.class,idUnidadGrupo );
        
        e.setTipo(tipo);
        e.setNombre(nombre);
        e.setFecha(sesionLaboratorio.getFechaSesison());
        e.setDescripcion(descripcion);
        e.setUnidadGrupo(ug);

        if (consulta.insertarObjeto(e)) {
            msj.setTitulo("Exíto");
            msj.setMensaje("Evento creado exitosamente");
            msj.MensajeInfo();
        } else {
            msj.setTitulo("Error");
            msj.setMensaje("Ocurrio un error al procesar la solicitud");
            msj.MensajeError();
        }
    }
    
    public List<UnidadGrupo> obtenerUnidadGrupo(){
        ConsultasHQL consulta  = new ConsultasHQL();
        return consulta.crearSelectQuery("FROM UnidadGrupo");
    }
    
    public void crearSesionLaboratorio() {
        
        Mensajes msj = new Mensajes();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        UnidadGrupo ug = new UnidadGrupo();
        SesionDeLaboratorio sl = new SesionDeLaboratorio();
        NotificacionesSesion ns = new NotificacionesSesion();
        
        ug = (UnidadGrupo) s.get(UnidadGrupo.class, idUnidadGrupo);
        
        sl.setFecha(sesionLaboratorio.getFechaSesison());
        sl.setDocenteAuxiliar(sesionLaboratorio.getDocenteAuxiliar());
        sl.setUnidadGrupo(ug);

        if (consulta.insertarObjeto(sl)) {
            
            // Crea la notificación una vez creada la sesión
            ns.setSesionDeLaboratorio(sl);
            ns.setDescripcion("Sesión de laboratorio : " 
                              + sl.getFecha() + " Grupo: "
                              + sl.getUnidadGrupo().getGrupo().getNombre() + " Unidad Aprendizaje: " + " Docente: "
                              + sl.getUnidadGrupo().getUsuariosByIdUsuariosDocente().getDatosUsuario().getNombre() + " "
                              + sl.getUnidadGrupo().getUsuariosByIdUsuariosDocente().getDatosUsuario().getApellidoPaterno());
            ns.setEstado( (byte) 1);
            consulta.insertarObjeto(ns);
            
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
    
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    public int getIdUnidadGrupo() {
        return idUnidadGrupo;
    }

    public void setIdUnidadGrupo(int idUnidadGrupo) {
        this.idUnidadGrupo = idUnidadGrupo;
    }
}
