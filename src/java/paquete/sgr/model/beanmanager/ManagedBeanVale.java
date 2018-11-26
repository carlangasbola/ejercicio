/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import paquete.sgr.beans.Equipos;
import paquete.sgr.beans.Materiales;
import paquete.sgr.beans.Reactivo;
import paquete.sgr.beans.Vales;
import paquete.sgr.entity.pojos.Vale;

/**
 *
 * @author César
 */



@Named(value = "managedBeanVale")
@SessionScoped
public class ManagedBeanVale implements Serializable {

    public ManagedBeanVale() {
        
    }
    
    static Date FechaSesion=new Date();
    static Vales vale = new Vales ();
    private String auxnombre;
    private double auxcantidad;
    static List<String> l = new ArrayList<>();
    
    
    public void eliminar(int posicion) {
        vale.listareactivos.remove(posicion);
    }
    
    public void add(String nombre, double cantidad) {
        Reactivo agrega = new Reactivo(nombre, cantidad);
        vale.listareactivos.add(agrega);
    }
    
    public void printPDF() throws JRException, IOException, CloneNotSupportedException{
        vale.EquipoAlumnos="Equipo";
        vale.listareactivos=ManagedBeanReactivos.lista;
        vale.listaequipo=ManagedBeanEquipo.lista;
        vale.listamaterial=ManagedBeanMaterial.list;
        int contador=0;
        for (Reactivo item:vale.listareactivos){
            if(contador==0){
                vale.listar=item.getNombre()+"\n";
                vale.r=item.getCantidad()+"\n";
                contador++;
            } 
            else{
                vale.listar=vale.listar+item.getNombre()+"\n";
                vale.r=vale.r+item.getCantidad()+"\n";
            }
                
        }
        
        contador=0;
        for (Materiales item:vale.listamaterial){
            if(contador==0){
                vale.listam=item.getNombre()+"\n";
                vale.m=item.getCantidad()+"\n";
                contador++;
            } 
            else{
                vale.listam=vale.listam+item.getNombre()+"\n";
                vale.m=vale.m+item.getCantidad()+"\n";
            }
        }
        
        contador=0;
        for (Equipos item:vale.listaequipo){
            if(contador==0){
                vale.listae=item.getNombre()+"\n";
                vale.e=item.getCantidad()+"\n";
                contador++;
            } 
            else{
                vale.listae=vale.listae+item.getNombre()+"\n";
                vale.e=vale.e+item.getCantidad()+"\n";
            }
        }
        
        List<Vales> datasource = new ArrayList<>();
        datasource.add(vale);
        String filename = "Vale ";
        String jasperPath = "/resources/Vale.jasper";
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
    
    //Getters y Setters
    
    public Date getFechaSesion() {
        return FechaSesion;
    }

    public void setFechaSesion(Date FechaSesion) {
        ManagedBeanVale.FechaSesion = FechaSesion;
    }

    public Vales getVale() {
        return vale;
    }

    public void setVale(Vales vale) {
        ManagedBeanVale.vale = vale;
    }

    public String getAuxnombre() {
        return auxnombre;
    }

    public void setAuxnombre(String auxnombre) {
        this.auxnombre = auxnombre;
    }

    public double getAuxcantidad() {
        return auxcantidad;
    }

    public void setAuxcantidad(double auxcantidad) {
        this.auxcantidad = auxcantidad;
    }
    
    
    
}
