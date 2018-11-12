package paquete.sgr.model.beanmanager;

import java.io.File;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import paquete.sgr.beans.Practica;
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
    private List<String> lista = new ArrayList<>();
    private String auxiliar;
    private String intro="C:\\Users\\César\\Documents\\NetBeansProjects\\ApiTest\\Prueba.jpg";
    
    public String irA(String number){
        return "creacionPractica"+ number;
    }
    public void limpialista(String autor){
        lista.clear();
        lista.add(autor);
    }
    public void agregarautor(String autor) {
        lista.add(autor);
    }
    public void eliminarautor(int posicion) {
        lista.remove(posicion);;
    }
    public void copia(){
        practica.autor=lista;
        practica.listamaterial=ManagedBeanMaterial.list;
        practica.listaequipo=ManagedBeanEquipo.lista;
        practica.listareactivos=ManagedBeanReactivos.lista;
        practica.imprime();
    }
        
    public void printPDF() throws JRException, IOException, CloneNotSupportedException{
        List<Practica> datasource = new ArrayList<>();
        datasource.add(practica);
        String filename = "Practica ";
        String jasperPath = "/resources/ReporteDePractica.jasper";
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

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public String getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(String auxiliar) {
        this.auxiliar = auxiliar;
    }
    
}