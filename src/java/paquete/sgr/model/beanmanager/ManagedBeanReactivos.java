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
import paquete.sgr.beans.Reactivo;
import paquete.sgr.entity.pojos.Reactivos;
import net.sf.jasperreports.engine.JRException;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.UnidadGrupo;
import paquete.sgr.entity.util.HibernateUtil;


@Named(value = "managedBeanReactivos")
@SessionScoped
public class ManagedBeanReactivos implements Serializable {
    
    // Declaracion de variables
    
    static List<Reactivo> lista;
    private List<String> list;
    private String auxnombre;
    private double auxcantidad;
    private double p1;
    private double p2;
    private double p3;
    private double um;
    private double y=0;
    private double networkOutput;
    private double networkOutput1;
    private double networkOutput2;
    private int[] tv={0,0,0,0,0,0,0,0,0}; 
    static String recomendaciones;
    static String protocolos;
    private String prueba;
    static String semaforo;
    private List<String> ReactivosF = new ArrayList<String>();
    private ConexionNeurona c = new ConexionNeurona();
    
    public ManagedBeanReactivos() {
        lista = new ArrayList<>();
    }
    
    //Agrega los reactivos a la lista que mustra la vista
    public void add(String nombre, double cantidad) {
        Reactivo agrega = new Reactivo(nombre, cantidad);
        lista.add(agrega);
        
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
    
    public void eliminar(int posicion) {
        lista.remove(posicion);;
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
        c.variables(tv[0],tv[1],tv[2],tv[3],tv[4],tv[5],tv[6],tv[7],tv[8]);
        c.RedNeuronal();
        networkOutput=c.networkOutput[0];
        networkOutput1=c.networkOutput[1];
        networkOutput2=c.networkOutput[2];
        
        //Salidas
        if(networkOutput>.8){
            
            String rs[] = {"","","","","","","","",""};
            for(Reactivo item:lista){
                
         
            ConsultasHQL consulta = new ConsultasHQL();
            List<Reactivos> re = consulta.crearSelectidUnidadGrupo("FROM Reactivos WHERE nombre = " + item.getNombre()) ;
            String rea = re.get(0).getTipo();
            
            if("Explosivo".equals(rea)){
                rs[0]=rea;
            }
            if("Inflamable".equals(rea)){
                rs[1]=rea;
            }
            if("Gas a presión".equals(rea)){
                rs[2]=rea;
            }
            if("Sustancia comburente".equals(rea)){
                rs[3]=rea;
            }
            if("Sustancia perjudicial para la salud".equals(rea)){
                rs[4]=rea;
            }
            if("Sustancia corrosiva".equals(rea)){
                rs[5]=rea;
            }
            if("Sustancia nosiva".equals(rea)){
                rs[6]=rea;
            }
            if("Sustancia tóxica".equals(rea)){
                rs[7]=rea;
            }
            if("Sustancia peligrosas para el medio ambiente".equals(rea)){
                rs[8]=rea;
            }

            
            }
            
            recomendaciones="Práctica con riesgo minimo: <br/> Sustancias:"+rs[0]+"-"+rs[1]+"-"+rs[2]+"-"+rs[3]+"-"+rs[4]+"-"+rs[5]+"-"+rs[6]+"-"+rs[7]+"-"+rs[8]+"<br/>Residuo: Se puede almacenar juntos.";
            protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //if(tv[0]==1){
                //recomendaciones="Práctica con riesgo minimo: Sustancia Corrosiva.<br/>Residuo: Se puede almacenar juntos.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //}
            //if(tv[1]==1){
                //recomendaciones="Práctica con riesgo minimo: Sustancia Inflamable.<br/>Residuo: Se puede almacenar juntos.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //}
            //if(tv[2]==1){
                //recomendaciones="Práctica con riesgo minimo: Sustancia Peligrosa.<br/>Residuo: Se puede almacenar juntos.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
           //}
            semaforo="/resources/semaforo/semaforob.png";
        }
        
        else{
            if(networkOutput1>.8){
                
                String rs[] = {"","","","","","","","",""};
            for(Reactivo item:lista){
                
         
            ConsultasHQL consulta = new ConsultasHQL();
            List<Reactivos> re = consulta.crearSelectidUnidadGrupo("FROM Reactivos WHERE nombre = " + item.getNombre()) ;
            String rea = re.get(0).getTipo();
            
            if("Explosivo".equals(rea)){
                rs[0]=rea;
            }
            if("Inflamable".equals(rea)){
                rs[1]=rea;
            }
            if("Gas a presión".equals(rea)){
                rs[2]=rea;
            }
            if("Sustancia comburente".equals(rea)){
                rs[3]=rea;
            }
            if("Sustancia perjudicial para la salud".equals(rea)){
                rs[4]=rea;
            }
            if("Sustancia corrosiva".equals(rea)){
                rs[5]=rea;
            }
            if("Sustancia nosiva".equals(rea)){
                rs[6]=rea;
            }
            if("Sustancia tóxica".equals(rea)){
                rs[7]=rea;
            }
            if("Sustancia peligrosas para el medio ambiente".equals(rea)){
                rs[8]=rea;
            }

            
            }
            
            recomendaciones="Práctica con riesgo medio: <br/> Sustancias:"+rs[0]+"-"+rs[1]+"-"+rs[2]+"-"+rs[3]+"-"+rs[4]+"-"+rs[5]+"-"+rs[6]+"-"+rs[7]+"-"+rs[8]+"<br/>Residuo: Colocar en distintos compartimientos. Puede requeririse una separacion longitudinal o vertical constituida por un compartimiento intermedio completo.";
            protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //if(tv[0]==1 && tv[1]==1){
                //recomendaciones="Práctica con riesgo medio: Sustancia Corrosiva y Sustancia inflamable.<br/>Residuo: Colocar en distintos compartimientos. Puede requeririse una separacion longitudinal o vertical constituida por un compartimiento intermedio completo.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //}
            //if(tv[0]==1 && tv[2]==1){
                //recomendaciones="Práctica con riesgo medio: Sustancia Corrosiva y Sustancia Peligrosa<br/>Residuo: Colocar en distintos compartimientos. Puede requeririse una separacion longitudinal o vertical constituida por un compartimiento intermedio completo.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //}
            semaforo="/resources/semaforo/semaforom.png";
        }
        
        if(networkOutput2>.8){
            
            String rs[] = {"","","","","","","","",""};
            for(Reactivo item:lista){
                
         
            ConsultasHQL consulta = new ConsultasHQL();
            List<Reactivos> re = consulta.crearSelectidUnidadGrupo("FROM Reactivos WHERE nombre = " + item.getNombre()) ;
            String rea = re.get(0).getTipo();
            
            if("Explosivo".equals(rea)){
                rs[0]=rea;
            }
            if("Inflamable".equals(rea)){
                rs[1]=rea;
            }
            if("Gas a presión".equals(rea)){
                rs[2]=rea;
            }
            if("Sustancia comburente".equals(rea)){
                rs[3]=rea;
            }
            if("Sustancia perjudicial para la salud".equals(rea)){
                rs[4]=rea;
            }
            if("Sustancia corrosiva".equals(rea)){
                rs[5]=rea;
            }
            if("Sustancia nosiva".equals(rea)){
                rs[6]=rea;
            }
            if("Sustancia tóxica".equals(rea)){
                rs[7]=rea;
            }
            if("Sustancia peligrosas para el medio ambiente".equals(rea)){
                rs[8]=rea;
            }

            
            }
            
            recomendaciones="Práctica con riesgo Alto: <br/> Sustancias:"+rs[0]+"-"+rs[1]+"-"+rs[2]+"-"+rs[3]+"-"+rs[4]+"-"+rs[5]+"-"+rs[6]+"-"+rs[7]+"-"+rs[8]+"<br/>Residuo: Colocar en compartimientos separados o bodega aparte.";
            protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\"><br/>NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //if(tv[0]==1 && tv[1]==1 && tv[2]==1){
                //recomendaciones="Práctica con riesgo Alto: Sustancia Corrosiva, Sustancia inflamable y Sustancia peligrosa.<br/>Residuo: Colocar en compartimientos separados o bodega aparte.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //}
            //if(tv[1]==1 && tv[2]==1){
                //recomendaciones="Práctica con riesgo Alto: Sustancia inflamable y Sustancia Peligrosa. Residuo:<br/>Colocar en compartimientos separados o bodega aparte.";
                //protocolos="<a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5411121\"><br/>NOM-018-STPS-2015</a> <br/> <a href=\"http://dof.gob.mx/nota_detalle.php?codigo=5072773\">NOM-017-STPS-2008</a> <br/> <a href=\"http://www.dof.gob.mx/nota_detalle_popup.php?codigo=5070081\">NOM- 026-STPS-2008</a>";
            //}
            
            semaforo="/resources/semaforo/semaforoa.png";
        }
            
        }
    }
    
    public void Seleccionar (){
        
        for(Reactivo item:lista){
            
            ConsultasHQL consulta = new ConsultasHQL();
            Reactivos reactivos = new Reactivos();
            List<Reactivos> re = consulta.crearSelectidUnidadGrupo("FROM Reactivos WHERE nombre = " + item.getNombre()) ;
            String rea = re.get(0).getTipo();
            System.out.println("reactivo: "+ item.getNombre() + " " +  rea);
        
            if("Explosivo".equals(rea)){
                tv[0]=1;
            }
            if("Inflamable".equals(rea)){
                tv[1]=1;
            }
            if("Gas a presión".equals(rea)){
                tv[2]=1;
            }
            if("Sustancia comburente".equals(rea)){
                tv[3]=1;
            }
            if("Sustancia perjudicial para la salud".equals(rea)){
                tv[4]=1;
            }
            if("Sustancia corrosiva".equals(rea)){
                tv[5]=1;
            }
            if("Sustancia nosiva".equals(rea)){
                tv[6]=1;
            }
            if("Sustancia tóxica".equals(rea)){
                tv[7]=1;
            }
            if("Sustancia peligrosas para el medio ambiente".equals(rea)){
                tv[8]=1;
            }

        }
        CalcularRiesgo();
    }
    
    // Getters y Setters
    public List<Reactivo> getLista() {
        return lista;
    }

    public void setLista(List<Reactivo> lista) {
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