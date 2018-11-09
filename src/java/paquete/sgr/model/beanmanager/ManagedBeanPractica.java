package paquete.sgr.model.beanmanager;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import paquete.sgr.beans.Equipo;
import paquete.sgr.beans.Material;
import paquete.sgr.beans.Practica;
import paquete.sgr.beans.Reactivos;
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
    //Se crea una practica
    Practica practica = new Practica();
    private String prueba="<table width=\"220\" height=500 border=\"0\" cellspacing=\"0\" cellpadding=\"1\"> \n" +
        "<tr bgcolor=\"#990033\" align=\"center\"> \n" +
        "<td><b><font color=\"#FFFFFF\">Titular del cuadro</font></b></td> \n" +
        "</tr> \n" +
        "<tr bgcolor=\"#990033\"> \n" +
        "<td> \n" +
        "<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"4\"> \n" +
        "<tr bgcolor=\"#FFFFFF\"> \n" +
        "<td>Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro\n" +
        "Ponga aqui el contenido del cuadro</td> \n" +
        "</tr> \n" +
        "</table> \n" +
        "</td> \n" +
        "</tr> \n" +
        "</table> ";
        
    public void guardar() throws JRException, IOException {        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito", " Datos guardados exitosamente ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String irA(String number){
        return "creacionPractica"+ number;
    }
    
    public void copia(){
        practica.autor=ManagedBeanUsuarios.nombrecompleto;
        practica.introduccion=prueba;
        practica.listamaterial=ManagedBeanMaterial.list;
        practica.listaequipo=ManagedBeanEquipo.lista;
        practica.listareactivos=ManagedBeanReactivos.lista;
    }
        
    public void printPDF() throws JRException, IOException, CloneNotSupportedException{
        copia();
        practica.imprime();
        List<Practica> datasource = new ArrayList<>();
        datasource.add(practica);
        String filename = "Practica ";
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

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        this.practica = practica;
    }
}