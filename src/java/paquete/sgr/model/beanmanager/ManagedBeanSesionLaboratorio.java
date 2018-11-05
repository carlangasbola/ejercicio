package paquete.sgr.model.beanmanager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

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
    private int idUnidadAprendizaje;
    private int idGrupo;
    private int idTecnico;
    private String docenteAuxiliar;
    
    public String diaMaximo(){
        return "1/1/26";
    }
    
    /** Getters and Setters
     * @return  **/
    
    public Date getFechaSesison() {
        return fechaSesison;
    }

    public void setFechaSesison(Date fechaSesison) {
        this.fechaSesison = fechaSesison;
    }

    public int getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(int idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
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
    
    
    
}
