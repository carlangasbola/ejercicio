/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.hibernate.Session;
import org.primefaces.model.*;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.ReportePractica;
/**
 *
 * @author César
 */
@Named(value = "managedBeanReporte")
@RequestScoped
public class ManagedBeanReportePractica {

    /**
     * Creates a new instance of ManagedBeanAgregarUsuariosArchivo
     */
    public ManagedBeanReportePractica() {
    }
    
    private UploadedFile file;

    public void save() throws IOException {
        String filename = FilenameUtils.getName(file.getFileName());
        InputStream input = file.getInputstream();
        OutputStream output = new FileOutputStream(new File("C:\\Practicas\\Reportes\\", filename));
        
        try {
            IOUtils.copy(input, output);
            FacesMessage message = new FacesMessage("El archivo", file.getFileName() + " se subió con éxito.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
        
        ConsultasHQL consulta = new ConsultasHQL();
        Session s= consulta.obtenerSession();
        
        consulta.crearListPair("idUsuario", getIdUsuarioSession());
        List<ReportePractica> reporte = consulta.crearSelectQuery("FROM ReportePractica where usuarios.idUsuarios = :idUsuario");
        
        int idR=reporte.get(0).getIdReportePractica();
        
        ReportePractica r = new ReportePractica();
        
        r=(ReportePractica) s.get(ReportePractica.class, idR);
        
        r.setGrupo("C:\\Practicas\\Reportes\\" + filename);
        consulta.actualizarObjeto(r);
        
    }
    
    
    public int getIdUsuarioSession() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        return (int) sessionMap.get("UserId");
    }
    
    public UploadedFile getFile() {
        return file;
    }
    
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
}
