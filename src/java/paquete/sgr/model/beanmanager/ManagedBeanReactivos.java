package paquete.sgr.model.beanmanager;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import paquete.sgr.beans.ConexionNeurona;
import paquete.sgr.beans.Reactivos;
import net.sf.jasperreports.engine.JRException;


@Named(value = "managedBeanReactivos")
@SessionScoped
public class ManagedBeanReactivos implements Serializable {
    
    // Declaracion de variables
    
    private List<Reactivos> lista;
    private List<String> list;
    private double p1;
    private double p2;
    private double p3;
    private double um;
    private double y=0;
    private double networkOutput;
    private double networkOutput1;
    private double networkOutput2;
    private int[] tv={0,0,0}; 
    private String recomendaciones;
    private String protocolos;
    private String prueba;
    private String semaforo;
    private List<String> ReactivosF = new ArrayList<String>();
    private ConexionNeurona c = new ConexionNeurona();
    
    // Inicializa el array de los materiales
    @PostConstruct
    public void init(){
        /*Aqui haremos una consulta a la base y obtendremos los materiales */
        list = new ArrayList<>();
        list.add("Hidróxido de sodio");
        list.add("Metanol");
        list.add("Glicerina");
        list.add("Ácido clorhídrico");
        list.add("Etanol");
        list.add("Acetona");
        list.add("Agua");
    }
    
    public ManagedBeanReactivos() {
        lista = new ArrayList<>();
            }
    
    //Agrega los reactivos a la lista que mustra la vista
    public void add() {
        lista.add(new Reactivos());
        
        if("Ácido clorhídrico".equals(prueba)){
            tv[0]=1;
        }
        if("Hidróxido de sodio".equals(prueba)){
            tv[0]=1;
        }
        if("Glicerina".equals(prueba)){
            tv[2]=1;
        }
        if("Metanol".equals(prueba)){
            tv[1]=1;
        }
        if("Etanol".equals(prueba)){
            tv[1]=1;
        }
        if("Acetona".equals(prueba)){
            tv[1]=1;
        }
    }
    
    // Remover un Equipo
    public void remove(){
        if (lista.size() > 0) {
            lista.remove(lista.size() - 1);
        } else {
            FacesContext.getCurrentInstance()
                    .addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Cuidado", "No existen valores para eliminar"));
        }
    }
    
    public void variables(double peso1,double peso2,double peso3, double umbral){
        p1=peso1;
        p2=peso2;
        p3=peso3;
        um=umbral;
    }
    public void guardar() throws JRException, IOException {        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Éxito", " Datos guardados exitosamente ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void CalcularRiesgo(){
        c.variables(tv[0],tv[1],tv[2]);
        c.RedNeuronal();
        networkOutput=c.networkOutput[0];
        networkOutput1=c.networkOutput[1];
        networkOutput2=c.networkOutput[2];

        //System.out.println("\nSalida: "+ networkOutput);
        //Salidas
        if(networkOutput>.8){
            if(tv[0]==1){
                recomendaciones="Práctica con riesgo minimo: Sustancia Corrosiva.<br/>Residuo: Se puede almacenar juntos.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            if(tv[1]==1){
                recomendaciones="Práctica con riesgo minimo: Sustancia Inflamable.<br/>Residuo: Se puede almacenar juntos.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            if(tv[2]==1){
                recomendaciones="Práctica con riesgo minimo: Sustancia Peligrosa.<br/>Residuo: Se puede almacenar juntos.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            semaforo="/resources/semaforo/semaforob.png";
        }
        
        if(networkOutput1>.8){
            if(tv[0]==1 && tv[1]==1){
                recomendaciones="Práctica con riesgo medio: Sustancia Corrosiva y Sustancia inflamable.<br/>Residuo: Colocar en distintos compartimientos. Puede requeririse una separacion longitudinal o vertical constituida por un compartimiento intermedio completo.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121&fecha=09/10/2015\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            if(tv[0]==1 && tv[2]==1){
                recomendaciones="Práctica con riesgo medio: Sustancia Corrosiva y Sustancia Peligrosa<br/>Residuo: Colocar en distintos compartimientos. Puede requeririse una separacion longitudinal o vertical constituida por un compartimiento intermedio completo.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121&fecha=09/10/2015\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            semaforo="/resources/semaforo/semaforom.png";
        }
        
        if(networkOutput2>.8){
            if(tv[0]==1 && tv[1]==1 && tv[2]==1){
                recomendaciones="Práctica con riesgo Alto: Sustancia Corrosiva, Sustancia inflamable y Sustancia peligrosa.<br/>Residuo: Colocar en compartimientos separados o bodega aparte.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121&fecha=09/10/2015\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            if(tv[1]==1 && tv[2]==1){
                recomendaciones="Práctica con riesgo Alto: Sustancia inflamable y Sustancia Peligrosa. Residuo:<br/>Colocar en compartimientos separados o bodega aparte.";
                protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121&fecha=09/10/2015\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773&fecha=09/12/2008\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            }
            
            semaforo="/resources/semaforo/semaforoa.png";
        }
    }
    
    public void Seleccionar (){
        
        for(Reactivos item:lista){
            
            System.out.println(item.getNombre());
        
            if("Ácido clorhídrico".equals(item.getNombre())){
                tv[0]=1;
            }
            if("Hidróxido de sodio".equals(item.getNombre())){
                tv[0]=1;
            }
            if("Glicerina".equals(item.getNombre())){
                tv[2]=1;
            }
            if("Metanol".equals(item.getNombre())){
                tv[1]=1;
            }
            if("Etanol".equals(item.getNombre())){
                tv[1]=1;
            }
            if("Acetona".equals(item.getNombre())){
                tv[1]=1;
            }

        }
        CalcularRiesgo();
    }
    
    // Getters y Setters
    public List<Reactivos> getLista() {
        return lista;
    }

    public void setLista(List<Reactivos> lista) {
        this.lista = lista;
    }
    
    public List<String> getList() {
        return list;
    }
    
    public void setList(List<String> list) {
        this.list = list;
    }
    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }
    public String getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(String protocolos) {
        this.protocolos = protocolos;
    }

    public String getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(String semaforo) {
        this.semaforo = semaforo;
    }
}
