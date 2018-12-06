package paquete.sgr.model.beanmanager;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.entity.pojos.ListaGrupo;
import paquete.sgr.entity.pojos.NotificacionesSesion;
import paquete.sgr.entity.pojos.SesionDeLaboratorio;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanNotificaciones")
@RequestScoped
public class ManagedBeanNotificaciones {
    
    List<NotificacionesSesion> listaSesiones;
    
    @PostConstruct
    public void init() {
        
    }

    public void notificacionSesionAlumno() {
        // Unidades Grupo en las cuales esta el alumno
        List<Integer> idUnidadesGrupo = new ArrayList<>();
         List<Integer> idSesiones = new ArrayList<>();
        ConsultasHQL consulta = new ConsultasHQL();
        int idAlumno = (int)consulta.obtenerDatosSesion("UserId");
        consulta.crearListPair("idUsuario", this);
        List<ListaGrupo> lg = consulta.crearSelectQuery("FROM ListaGrupo WHERE usuarios.idUsuarios = :idUsuario");
        
        /*
        // Guardamos todos los id de unidad grupo
        for( ListaGrupo lgs : lg ){
            idUnidadesGrupo.add(lgs.getUnidadGrupo().getIdUnidadGrupo());
        }
        
        // Obtenemos las sesiones
        for(Integer i : idUnidadesGrupo){
            consulta.crearListPair("idunidadGrupo", i);
            List<SesionDeLaboratorio> sl 
                = consulta.crearSelectQuery("FROM SesionDeLaboratorio WHERE unidadGrupo.idUnidadGrupo = :idunidadGrupo");
            idSesiones.add(sl.get(0).getIdSesion());
        }
        
        // Las notificaciones 
        for(Integer i : idSesiones){
            consulta.crearListPair("idunidadGrupo", i);
        }
        */
        
    }
    
    public List<NotificacionesSesion> getListaSesiones() {
        return listaSesiones;
    }

    public void setListaSesiones(List<NotificacionesSesion> listaSesiones) {
        this.listaSesiones = listaSesiones;
    }

}
