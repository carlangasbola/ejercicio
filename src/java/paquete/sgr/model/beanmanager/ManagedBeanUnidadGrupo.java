package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedProperty;

@Named(value = "managedBeanUnidadGrupo")
@Dependent
public class ManagedBeanUnidadGrupo {

    private int idDocente;
    private int idTecnico;

    @ManagedProperty(value = "#{managedBeanGrupos}")
    private ManagedBeanGrupos grupos;

    // Constructor
    public ManagedBeanUnidadGrupo() {
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


}
