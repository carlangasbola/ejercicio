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
    
    // Declaracion de variables ( 1er parte del modulo practica )
    private int numeropractica ;
    private String titulopractica;
    private String autor;
    private String objetivos;
    private String actividadprevia;
    private String introduccion;

    // Declaración de variables (3r parte del modulo practica)
    private String desarrolloexp;
    private String registrodatos;
    private String resultados;
    private String analiresul;
    private String referencias;
    private String nomenclatura;
    private String anexos;
    
    public void guardar() throws JRException, IOException {        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito", " Datos guardados exitosamente ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String irA(String number){
        return "creacionPractica"+ number;
    }
    /*
    public void printPDF() throws JRException, IOException{
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito", " Datos guardados exitosamente ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        List<Practica> datasource = new ArrayList<>();
        datasource.add(new Practica(numeropractica, titulopractica, "competencia", "semestre", "creador", "Usuario actual", objetivos, ManagedBeanMaterial.list));
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
    }*/

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
    
    public String getEditor() {
        return introduccion;
    }

    public void setEditor(String introduccion) {
        this.introduccion = introduccion;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getActividadprevia() {
        return actividadprevia;
    }

    public void setActividadprevia(String actividadprevia) {
        this.actividadprevia = actividadprevia;
    }

    public String getIntroduccion() {
        return introduccion;
    }

    
    public void setIntroduccion(String introduccion) {
        this.introduccion = introduccion;
    }
    
    
    public String getDesarrolloexp() {
        return desarrolloexp;
    }

    public void setDesarrolloexp(String desarrolloexp) {
        this.desarrolloexp = desarrolloexp;
    }

    public String getRegistrodatos() {
        return registrodatos;
    }

    public void setRegistrodatos(String registrodatos) {
        this.registrodatos = registrodatos;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getAnaliresul() {
        return analiresul;
    }

    public void setAnaliresul(String analiresul) {
        this.analiresul = analiresul;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }
    
}