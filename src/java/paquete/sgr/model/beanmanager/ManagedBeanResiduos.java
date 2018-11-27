/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author César
 */

@Named(value = "managedBeanResiduos")
@SessionScoped

public class ManagedBeanResiduos implements Serializable {
    static int aux;
    static int opcion;
    static int explosivos=1000;
    static int inflamables=530;
    static int gasesapresion=683;
    static int comburentes=879;
    static int sustanciasperjudiciales=300;
    static int corrosivas=230;
    static int sustanciasnosivas=399;
    static int sustanciastoxicas=1100;
    static int peligrosasmedioambiente=891;
    
    
    
    public void ingresa(int entrada, int opcion){
        if(opcion==1)
            explosivos=explosivos+entrada;
        if(opcion==2)
            inflamables=entrada+inflamables;
        if(opcion==3)
            gasesapresion=gasesapresion+entrada;
        if(opcion==4)
            comburentes=comburentes+entrada;
        if(opcion==5)
            sustanciasperjudiciales=sustanciasperjudiciales+entrada;
        if(opcion==6)
            corrosivas=corrosivas+entrada;
        if(opcion==7)
            sustanciasnosivas=sustanciasnosivas+entrada;
        if(opcion==8)
            sustanciastoxicas=sustanciastoxicas+entrada;
        if(opcion==9)
            peligrosasmedioambiente=peligrosasmedioambiente+entrada;
        
    }
    
    
    public int getExplosivos() {
        return explosivos;
    }

    public void setExplosivos(int explosivos) {
        ManagedBeanResiduos.explosivos = explosivos;
    }

    public int getInflamables() {
        return inflamables;
    }

    public void setInflamables(int inflamables) {
        ManagedBeanResiduos.inflamables = inflamables;
    }

    public int getGasesapresion() {
        return gasesapresion;
    }

    public void setGasesapresion(int gasesapresion) {
        ManagedBeanResiduos.gasesapresion = gasesapresion;
    }

    public int getComburentes() {
        return comburentes;
    }

    public void setComburentes(int comburentes) {
        ManagedBeanResiduos.comburentes = comburentes;
    }

    public int getSustanciasperjudiciales() {
        return sustanciasperjudiciales;
    }

    public void setSustanciasperjudiciales(int sustanciasperjudiciales) {
        ManagedBeanResiduos.sustanciasperjudiciales = sustanciasperjudiciales;
    }

    public int getCorrosivas() {
        return corrosivas;
    }

    public void setCorrosivas(int corrosivas) {
        ManagedBeanResiduos.corrosivas = corrosivas;
    }

    public int getSustanciasnosivas() {
        return sustanciasnosivas;
    }

    public void setSustanciasnosivas(int sustanciasnosivas) {
        ManagedBeanResiduos.sustanciasnosivas = sustanciasnosivas;
    }

    public int getSustanciastoxicas() {
        return sustanciastoxicas;
    }

    public void setSustanciastoxicas(int sustanciastoxicas) {
        ManagedBeanResiduos.sustanciastoxicas = sustanciastoxicas;
    }

    public int getPeligrosasmedioambiente() {
        return peligrosasmedioambiente;
    }

    public void setPeligrosasmedioambiente(int peligrosasmedioambiente) {
        ManagedBeanResiduos.peligrosasmedioambiente = peligrosasmedioambiente;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        ManagedBeanResiduos.aux = aux;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        ManagedBeanResiduos.opcion = opcion;
    }
                    
    
    
    
    
    
}
