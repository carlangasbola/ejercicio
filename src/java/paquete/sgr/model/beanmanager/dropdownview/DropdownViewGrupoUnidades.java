package paquete.sgr.model.beanmanager.dropdownview;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.Grupo;
import paquete.sgr.entity.pojos.UnidadAprendizaje;

@ManagedBean
@SessionScoped
public class DropdownViewGrupoUnidades implements Serializable {

    private Map<String, Map<String, String>> data = new HashMap<String, Map<String, String>>();
    private String id_Grupo;
    private String id_UnidadAprendizaje;
    private Map<String, String> grupos;
    private Map<String, String> unidades_aprendizaje;

    @PostConstruct
    public void init() {
        /*La primer  propiedad es lo que se muestra (DEBE SER UNICO) */
        /*La segunda propiedad es el valor que tiene  */
        grupos = new HashMap<>();

        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
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
                String a = listua.getIdUnidadAprendizaje().toString();
                map.put(  listua.getNombre() + " " + a,  listua.getIdUnidadAprendizaje().toString() );
            }
            data.put(g.getIdGrupo().toString(), map);
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
