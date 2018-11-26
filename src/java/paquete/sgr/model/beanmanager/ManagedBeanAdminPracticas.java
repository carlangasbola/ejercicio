/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.sgr.model.beanmanager;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.Practicas;
import paquete.sgr.entity.pojos.Practica;
import paquete.sgr.entity.pojos.UnidadTematica;
import paquete.sgr.entity.pojos.Usuarios;
import paquete.sgr.beans.*;
import paquete.sgr.entity.pojos.DatosPractica;
import paquete.sgr.entity.pojos.Equipo;
import paquete.sgr.entity.pojos.EquipoLaboratorio;
import paquete.sgr.entity.pojos.EquipoUtilizado;
import paquete.sgr.entity.pojos.MaterialUtilizado;
import paquete.sgr.entity.pojos.Material;
import paquete.sgr.entity.pojos.Reactivos;
import paquete.sgr.entity.pojos.ReactivosUtilizadoPractica;

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
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from practica").addEntity(Practica.class);
        List<Practica> practica = query.list();
        return practica;
    }
    public List<Usuarios> getUsuarios(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from usuarios where idUsuarios='"+id+"'").addEntity(Practica.class);
        List<Usuarios> usuarios = query.list();
        return usuarios;
    }
    
    public List<UnidadTematica> getUnidades(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from unidad_tematica where idUnidad_Tematica='" + id + "'").addEntity(UnidadTematica.class);
        List<UnidadTematica> unidades = query.list();
        return unidades;
    }
    
    public List<MaterialUtilizado> getMaterial(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from material_utilizado where idPractica='" + id + "'").addEntity(MaterialUtilizado.class);
        List<MaterialUtilizado> materialUtilizado = query.list();
        return materialUtilizado;
    }
    
    public List<EquipoUtilizado> getEquipo(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from equipo_utilizado where idPractica='" + id + "'").addEntity(EquipoUtilizado.class);
        List<EquipoUtilizado> equipoUtilizado = query.list();
        return equipoUtilizado;
    }
    
    public List<ReactivosUtilizadoPractica> getReactivos(int id){
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from reactivos_utilizado_practica where idPractica='" + id + "'").addEntity(ReactivosUtilizadoPractica.class);
        List<ReactivosUtilizadoPractica> reactivoUtilizado = query.list();
        return reactivoUtilizado;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    
    public List<UnidadTematica> getUnidadesT() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from unidad_tematica").addEntity(UnidadTematica.class);
        List<UnidadTematica> unidad = query.list();
        return unidad;
    }
    
    public int buscaIdPractica() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from practica").addEntity(Practica.class);
        List<Practica> p = query.list();
        System.out.println("numero de id"  + p.get(p.size()-1).getIdPractica());
        return p.get(p.size()-1).getIdPractica();
    }
    
    public int buscaNoDatos() {
        ConsultasHQL consulta = new ConsultasHQL();
        hibernateSession = consulta.obtenerSession();
        Query query = hibernateSession.createSQLQuery("select *from datos_practica").addEntity(DatosPractica.class);
        List<DatosPractica> p = query.list();
        System.out.println("numero de id"  + (p.get(p.size()-1).getNumeroPractica())+(1));
        return 1;
    }
    
    
    public void eliminarPractica(int idpractica) {
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.getHibernateSession();
        Practica r = (Practica) s.load(Practica.class, idpractica);
        consulta.eliminarObjeto(r);
    }
    
    public void crearPractica(int idUnidadTematica) {
        Mensajes m = new Mensajes();
        Date fecha = new Date();
        ConsultasHQL cmd  = new ConsultasHQL();
        hibernateSession = cmd.obtenerSession();
        
        try {
            hibernateSession.beginTransaction();
            Practica practica1 = new Practica();
            
            Usuarios user = (Usuarios) hibernateSession.get(Usuarios.class,ManagedBeanUsuarios.idusuario);
            UnidadTematica unidad = (UnidadTematica)hibernateSession.get(UnidadTematica.class,2);
            practica1.setCreacion(fecha);
            practica1.setUsuarios(user);
            practica1.setUnidadTematica(unidad);
            hibernateSession.save(practica1);
            
            DatosPractica datos = new DatosPractica();
            datos.setPractica(practica1);
            datos.setNumeroPractica(5);
            datos.setNombre(ManagedBeanPractica.practica.titulopractica);
            datos.setEditor("Editores");
            datos.setActualizacion(fecha);
            datos.setIntroducion(ManagedBeanPractica.practica.introduccion);
            datos.setActividadesPrevias(ManagedBeanPractica.practica.actividadesprevias);
            datos.setObjetivos(ManagedBeanPractica.practica.objetivos);
            datos.setSemaforo(ManagedBeanPractica.practica.semaforo);
            datos.setRecomendaciones(ManagedBeanPractica.practica.recomendaciones);
            datos.setProtocolos(ManagedBeanPractica.practica.protocolosdeactuacion);
            datos.setDesarrollo(ManagedBeanPractica.practica.desarrolloexperimental);
            datos.setRegistroDatos(ManagedBeanPractica.practica.registrodedatos);
            datos.setResultados(ManagedBeanPractica.practica.resultados);
            datos.setAnalisisResultados(ManagedBeanPractica.practica.analisisderesultados);
            datos.setReferencias(ManagedBeanPractica.practica.referencias);
            datos.setNomeclantura(ManagedBeanPractica.practica.nomenclatura);
            datos.setAnexos(ManagedBeanPractica.practica.anexos);
            hibernateSession.save(datos);
            
            ReactivosUtilizadoPractica r = new ReactivosUtilizadoPractica();
            
            for (Reactivo item:ManagedBeanReactivos.lista){
                Query query = 
                        hibernateSession.createQuery("FROM Reactivos WHERE nombre =:name")
                                .setParameter("name", item.getNombre());
                
                Reactivos reactivo = (Reactivos) query.uniqueResult();
                Reactivos reac = (Reactivos) hibernateSession.get(Reactivos.class,reactivo.getIdReactivo());
                r.setReactivos(reac);
            }
            r.setPractica(practica1);
            
            hibernateSession.save(r);
            
            MaterialUtilizado ma = new MaterialUtilizado();
            
            for (Materiales item:ManagedBeanMaterial.list){
                Query query = 
                        hibernateSession.createQuery("FROM Material WHERE nombre =:name")
                                .setParameter("name", item.getNombre());
                
                Material mat = (Material) query.uniqueResult();
                Material mate = (Material) hibernateSession.get(Material.class,mat.getIdMaterial());
                ma.setMaterial(mate);
            }
            ma.setPractica(practica1);
            hibernateSession.save(ma);
            
            EquipoUtilizado e = new EquipoUtilizado();
            
            for (Equipos item:ManagedBeanEquipo.lista){
                Query query = 
                        hibernateSession.createQuery("FROM EquipoLaboratorio WHERE nombre =:name")
                                .setParameter("name", item.getNombre());
                
                EquipoLaboratorio equipo = (EquipoLaboratorio) query.uniqueResult();
                EquipoLaboratorio eq = (EquipoLaboratorio) hibernateSession.get(EquipoLaboratorio.class,equipo.getIdEquipoLaboratorio());
                e.setEquipoLaboratorio(eq);
            }
            e.setPractica(practica1);
            hibernateSession.save(e);
            
            hibernateSession.getTransaction().commit();
            m.setTitulo("Información");
            m.setMensaje("Practica creada con éxito");
            m.MensajeInfo();
        } catch (Exception e) {
            hibernateSession.getTransaction().rollback();
            m.setTitulo("Fatal");
            m.setMensaje("Algo salio mal");
            m.MensajeFaltal();
            System.out.println("Exepcion : " + e);
        }
    }

    
    
}
