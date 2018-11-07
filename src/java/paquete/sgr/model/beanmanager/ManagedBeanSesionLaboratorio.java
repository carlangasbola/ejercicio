package paquete.sgr.model.beanmanager;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
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
