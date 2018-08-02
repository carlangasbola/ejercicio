package controlador;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import modelo.Practica;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanPractica")
@SessionScoped
public class ManagedBeanPractica implements Serializable {
    
    // constructir por defecto
    public ManagedBeanPractica(){
    }
    
    // Declaracion de variables
    private int numeropractica ;
    private String titulopractica;
    private String competencias;
    private String semestre;
    private String creador;
    private String editor;
    private String objetivos;
    
    public void guardar() throws JRException, IOException {        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito", " Datos guardados exitosamente ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String enviar(){
        return "creacionPractica2";
    }
    
    public String regresar(){
        return "crearpractica1";
    }
    
    public void printPDF() throws JRException, IOException{
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito", " Datos guardados exitosamente ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        List<Practica> datasource = new ArrayList<>();
        datasource.add(new Practica(numeropractica, titulopractica, competencias, semestre, creador, "Usuario actual", objetivos));
        String filename = "Practica "+ numeropractica;
        String jasperPath = "/resources/FormatoDePractica.jasper";
        this.PDF(null, jasperPath, datasource, filename);
     }
     
    public void PDF(Map<String,Object> params, String JasperPath, List<?> dataSource, String fileName)throws JRException, IOException{
        String relativeWebPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(JasperPath);
        File file = new File(relativeWebPath);
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(dataSource, false);
        JasperPrint print = JasperFillManager.fillReport(file.getPath(), params, source);
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Context-disposition", "attachment;filename= " + fileName);
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(print, stream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public int getNumeropractica() {
        return numeropractica;
    }

    public void setNumeropractica(int numeropractica) {
        this.numeropractica = numeropractica;
    }

    public String getTitulopractica() {
        return titulopractica;
    }

    public void setTitulopractica(String titulopractica) {
        this.titulopractica = titulopractica;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
    
}