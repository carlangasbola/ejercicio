/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.util.HibernateUtil;
import paquete.sgr.entity.pojos.SesionDeLaboratorio;

/**
 *
 * @author César
 */

@Named(value = "managedBeanLab")
@RequestScoped

public class ManagedBeanLaboratorio {
    
    /*Crecion de variables para la recuperacion de datos*/
    private Session hibernateSession;
    private String nombrereactivo;
    private String tiporeactivo;
    private double cantidadreactivo;
    private byte existenciareactivo;
    private String medidareactivo;
    private int id_Reactivo;
    
    //Se obtiene solo la fecha actual
    
    private List<Date> listafechas;
    
    public List<SesionDeLaboratorio> getSesiones() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery(" select *from sesion_de_laboratorio").addEntity(SesionDeLaboratorio.class);
        List<SesionDeLaboratorio> sesion = query.list();
        return sesion;
    }
    
    public int obtenfecha(int id) {
        int salida=0;
        String resultado = new String();
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery(" select *from sesion_de_laboratorio").addEntity(SesionDeLaboratorio.class);
        List<SesionDeLaboratorio> sesion = query.list();
        for(paquete.sgr.entity.pojos.SesionDeLaboratorio item:sesion){
            if (item.getIdSesion()==id){
                System.out.println("fecha de la s: " + item.getFecha() + "Sistema" + fecha);
                calendar.setTime(item.getFecha());
                calendar.add(Calendar.HOUR,2);
                if (item.getFecha().before(fecha))
                    resultado= "La Fecha de la practica es menor ";
                else{
                    if ( fecha.before(item.getFecha()) ){
                        resultado= "La Fecha de la practica es mayor ";
                    }else{
                        resultado= "Las Fechas Son iguales ";
                    }
                }
                Date fechaSalida = calendar.getTime();
                if(item.getFecha().before(fecha)&& fecha.before(fechaSalida)){
                    salida=1;
                }
            }
        }
        //calendar.add(Calendar.MINUTE, minutosASumar); //minutosASumar es int.
        //calendar.add(Calendar.HOUR,   horasASumar); //horasASumar es int.
         //Y ya tienes la fecha sumada.
        System.out.println(resultado);
        return salida;
    }
    
    
    public String redirecciona() {
        String direccion="prestamoNoDisponible.xhtml";
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from sesion_de_laboratorio").addEntity(SesionDeLaboratorio.class);
        List<SesionDeLaboratorio> sesion = query.list();
        for(paquete.sgr.entity.pojos.SesionDeLaboratorio item:sesion)
            if(obtenfecha(item.getIdSesion())==1){
                ManagedBeanVale.FechaSesion=item.getFecha();
                return "modPrestamos.xhtml";
            }
        
        return direccion;
    }

    public int getId_Reactivo() {
        return id_Reactivo;
    }

    public void setId_Reactivo(int id_Reactivo) {
        this.id_Reactivo = id_Reactivo;
    }
    
    public Session getHibernateSession() {
        return hibernateSession;
    }

    public void setHibernateSession(Session hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    public String getNombrereactivo() {
        return nombrereactivo;
    }

    public void setNombrereactivo(String nombrereactivo) {
        this.nombrereactivo = nombrereactivo;
    }

    public String getTiporeactivo() {
        return tiporeactivo;
    }

    public void setTiporeactivo(String tiporeactivo) {
        this.tiporeactivo = tiporeactivo;
    }

    public double getCantidadreactivo() {
        return cantidadreactivo;
    }

    public void setCantidadreactivo(double cantidadreactivo) {
        this.cantidadreactivo = cantidadreactivo;
    }

    public byte getExistenciareactivo() {
        return existenciareactivo;
    }

    public void setExistenciareactivo(byte existenciareactivo) {
        this.existenciareactivo = existenciareactivo;
    }

    public String getMedidareactivo() {
        return medidareactivo;
    }

    public void setMedidareactivo(String medidareactivo) {
        this.medidareactivo = medidareactivo;
    }
    
    
    
}
