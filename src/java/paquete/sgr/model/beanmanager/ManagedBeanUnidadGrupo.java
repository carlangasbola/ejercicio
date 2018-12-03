package paquete.sgr.model.beanmanager;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.ListaGrupo;
import paquete.sgr.entity.pojos.UnidadGrupo;

@Named(value = "managedBeanUnidadGrupo")
@Dependent
public class ManagedBeanUnidadGrupo {

    private int idDocente;
    private int idTecnico;
    
    private List<UnidadGrupo> ListaUnidadGrupo;
    private List<ListaGrupo> ListaGrupo;

    @ManagedProperty(value = "#{managedBeanGrupos}")
    private ManagedBeanGrupos grupos;

    // Constructor
    public ManagedBeanUnidadGrupo() {
    }
    
    public String redireccionarListaGrupo(int idUnidadGrupo){
        ConsultasHQL consulta = new ConsultasHQL();
        consulta.crearListPair("id", idUnidadGrupo);
        ListaGrupo = consulta.crearSelectQuery("FROM ListaGrupo where unidadGrupo.idUnidadGrupo = :id");
        return "listaGrupo";
    }

    /* Getters y Setters*/
    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public ManagedBeanGrupos getGrupo() {
        return grupos;
    }

    public void setGrupo(ManagedBeanGrupos grupo) {
        this.grupos = grupo;
    }

    public ManagedBeanGrupos getGrupos() {
        return grupos;
    }

    public void setGrupos(ManagedBeanGrupos grupos) {
        this.grupos = grupos;
    }
    
    public List<UnidadGrupo> getListaUnidadGrupo() {
        ConsultasHQL consulta = new ConsultasHQL();
        ListaUnidadGrupo = consulta.crearSelectQuery("FROM UnidadGrupo");
        return ListaUnidadGrupo;
    }

    public void setListaUnidadGrupo(List<UnidadGrupo> ListaUnidadGrupo) {
        this.ListaUnidadGrupo = ListaUnidadGrupo;
    }
    
    public List<ListaGrupo> getListaGrupo() {
        return ListaGrupo;
    }

    public void setListaGrupo(List<ListaGrupo> ListaGrupo) {
        this.ListaGrupo = ListaGrupo;
    }
}
