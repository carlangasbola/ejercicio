package paquete.sgr.model.beanmanager;

import java.io.File; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.OutputStream; 
import org.xhtmlrenderer.pdf.ITextRenderer; 
import com.lowagie.text.DocumentException; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import paquete.sgr.beans.Practicas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.model.DefaultStreamedContent;
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
    //Se crean variables para poder descargar ficheros
    private String direccion;
    private DefaultStreamedContent descarga;
    
    //Se crea una practica
    
    static Practicas practica = new Practicas();
    static int idUnidadAprendizaje;
    static int idUsuario;
    
    static List<String> lista = new ArrayList<>();
    private String auxiliar;
    
    public String irA(String number){
        return "creacionPractica"+ number;
    }
    static void limpialista(String autor){
        lista.clear();
        lista.add(autor);
    }
    public void agregarautor(String autor) {
        lista.add(autor);
    }
    public void eliminarautor(int posicion) {
        lista.remove(posicion);
    }
    public void copia(){
        practica.autor=lista;
        practica.listamaterial=ManagedBeanMaterial.list;
        practica.listaequipo=ManagedBeanEquipo.lista;
        practica.listareactivos=ManagedBeanReactivos.lista;
        practica.imprime();
    }
        
    public void printPDF() throws JRException, IOException, CloneNotSupportedException{
        List<Practicas> datasource = new ArrayList<>();
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
    
    
    public void ImprimePDF() throws MalformedURLException, FileNotFoundException, DocumentException, IOException{
        crea();
        String inputFile = "C:\\Practicas\\Creacion\\" + practica.titulopractica + ".html"; 
        String url = new File(inputFile).toURI().toURL().toString(); 
        String outputFile = "C:\\Practicas\\Archivos\\" + practica.titulopractica + ".pdf";; 
        OutputStream os = new FileOutputStream(outputFile);
        ITextRenderer renderer = new ITextRenderer(); 
        renderer.setDocument(url); 
        renderer.layout(); 
        renderer.createPDF(os); 

        os.close();  
    }
    
    public void crea(){
        try {
		File fileDir = new File("C:\\Practicas\\Creacion\\" + practica.titulopractica + ".html");
		Writer out = new BufferedWriter(new OutputStreamWriter(
			new FileOutputStream(fileDir), "UTF8"));
		out.append(LeeArchivo("C:\\Practicas\\Creacion\\inicio.txt") + LlenaContenido() + LeeArchivo("C:\\Practicas\\Creacion\\fin.txt"));
		out.flush();
		out.close();
	        
	    } 
	   catch (UnsupportedEncodingException e) 
	   {
		System.out.println(e.getMessage());
	   } 
	   catch (IOException e) 
	   {
		System.out.println(e.getMessage());
	    }
	   catch (Exception e)
	   {
		System.out.println(e.getMessage());
	   } 
    }
    
    public String LlenaContenido(){
            String salida;
            //Requisitos
            salida= "<br/><center><span style=\"font-size:16px\"><strong>" + practica.titulopractica + "</strong></span></center><br/><br/>";
            salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>OBJETIVOS</strong></span></left><br/><br/>" + practica.objetivos;
            salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>ACTIVIDADES PREVIAS</strong></span></left><br/><br/>" + practica.actividadesprevias;
            salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>INTRODUCCIÓN</strong></span></left><br/><br/>" + practica.introduccion;
            //Materiales y equipo
            
            //Desarrollo de la practica
            salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>DESARROLLO EXPERIMENTAL</strong></span></left><br/><br/>" + practica.desarrolloexperimental;
            salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>REGISTRO DE DATOS</strong></span></left><br/><br/>" + practica.registrodedatos;
            salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>RESULTADOS</strong></span></left><br/><br/>" + practica.resultados;
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>ANÁLISIS DE RESULTADOS</strong></span></left><br/><br/>" + practica.analisisderesultados;
            //Información adicional
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>REFERENCIAS</strong></span></left><br/><br/>" + practica.referencias;
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>NOMENCLATURA</strong></span></left><br/><br/>" + practica.nomenclatura;
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>ANEXOS</strong></span></left><br/><br/>" + practica.anexos;
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>PROTOCOLOS DE ACTUACIÓN</strong></span></left><br/><br/>" + ManagedBeanReactivos.protocolos;
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>RECOMENDACIONES</strong></span></left><br/><br/>" + ManagedBeanReactivos.recomendaciones;
            //salida= salida + "<br/><br/><left><span style=\"font-size:16px\"><strong>SEMÁFORO</strong></span></left><br/><br/>" + ManagedBeanReactivos.semaforo;
            
        return salida;
    }
    
    public String CompruebaEtiquetas(String texto){
        return texto.replace("<br>", "<br/>");
    }
    
    
    public String LeeArchivo(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    
    public void preparaDescarga(String direccion) throws Exception {
        direccion="C:\\Practicas\\Archivos\\" + practica.titulopractica + ".pdf";
        File archivo = new File(direccion);
        InputStream entrada = new FileInputStream(archivo);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        setDescarga(new DefaultStreamedContent(entrada, externalContext.getMimeType(archivo.getName()), archivo.getName()));
    }
    
    //Getters y setters

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public DefaultStreamedContent getDescarga() {
        return descarga;
    }

    public void setDescarga(DefaultStreamedContent descarga) {
        this.descarga = descarga;
    }
    
    public Practicas getPractica() {
        return practica;
    }

    public void setPractica(Practicas practica) {
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

    public int getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(int idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }
    
}