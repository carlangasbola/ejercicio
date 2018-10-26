/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import paquete.sgr.beans.UtilPath;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
/**
 *
 * @author Jorge
 */
@Named(value = "managedBeanUpload")
@SessionScoped
public class ManagedBeanUpload implements Serializable {

    /**
     * Creates a new instance of ManagedBeanUpload
     */
    static String fileName="";
    
    public ManagedBeanUpload() {
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        fileName=file.getFileName();
        System.out.println(fileName);
        byte[] contents=file.getContents();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String realPath = UtilPath.getUrlDefinida(ec.getRealPath("/"));
        String pathDefinition = realPath + File.separator + "web" + File.separator + "ExcelUpload" + File.separator + file.getFileName();
        try {
            //FileInputStream in = (FileInputStream) file.getInputstream();
            FileOutputStream out = new FileOutputStream(pathDefinition);
            out.write(contents);
            out.close();

            //byte[] buffer = new byte[(int) file.getSize()];
            //int contador = 0;

            //while ((contador = in.read(buffer)) != -1) {
                //out.write(buffer, 0, contador);
            //}
            //in.close();
            //out.close();
            //System.out.println(""+pathDefinition);

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
        
        FacesMessage message = new  FacesMessage("Carga Correcta",event.getFile().getFileName()+ " cargado al sistema");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
