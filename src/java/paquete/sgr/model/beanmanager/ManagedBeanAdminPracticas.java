/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.Practicas;
import paquete.sgr.entity.pojos.Practica;
import paquete.sgr.entity.pojos.UnidadTematica;
import paquete.sgr.entity.util.HibernateUtil;

/**
 *
 * @author César
 */

@Named(value = "managedBeanAdminPracticas")
@RequestScoped

public class ManagedBeanAdminPracticas {
    /*Creacion de variables para la recuperacion de datos*/
    private Session hibernateSession;
    
    Practicas practica = new Practicas();
    
    public List<Practica> getPracticas() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from practica").addEntity(Practica.class);
        List<Practica> practica = query.list();
        return practica;
    }
    
    public List<UnidadTematica> getUnidadTematica(int id) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query query = hibernateSession.createSQLQuery("select *from unidad_tematica whete id="+id).addEntity(Practica.class);
        List<UnidadTematica> ut = query.list();
        return ut;
    }
    
    
}
