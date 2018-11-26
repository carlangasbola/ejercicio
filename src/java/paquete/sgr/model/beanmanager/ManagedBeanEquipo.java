package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.beans.Equipos;

@Named(value = "managedBeanEquipo")
@SessionScoped
public class ManagedBeanEquipo implements Serializable {
    
    // Definicion de variables
    static List<Equipos> lista;
    private String auxnombre;
    private int auxcantidad;
    /**
     * Creates a new instance of ManagedBeanEquipo
     */
    public ManagedBeanEquipo() {
        lista = new ArrayList<>();
    }
    
    public void agregarMaterial() throws SQLException{
        int id=1;
        ConsultasHQL c = new ConsultasHQL();
        Session s = c.obtenerSession();
        
        SessionImplementor miSessionImplementor = (SessionImplementor) s;
        Connection conn = miSessionImplementor.connection();
 
        CallableStatement call = conn.prepareCall("{ call AumentarCantidadaaa(?) }");
        call.setInt(1, id);
        call.execute();
        
    }
    
    // Agregar un nuevo equipo
    public void add(String nombre, int cantidad) {
        Equipos agrega = new Equipos(nombre, cantidad);
        lista.add(agrega);
    }
    
    public void eliminar(int posicion) {
        lista.remove(posicion);
    }
    
    // Getters y Setters
    public List<Equipos> getLista() {
        return lista;
    }

    public void setLista(List<Equipos> lista) {
        this.lista = lista;
    }

    public String getAuxnombre() {
        return auxnombre;
    }

    public void setAuxnombre(String auxnombre) {
        this.auxnombre = auxnombre;
    }

    public int getAuxcantidad() {
        return auxcantidad;
    }

    public void setAuxcantidad(int auxcantidad) {
        this.auxcantidad = auxcantidad;
    }
    
}
