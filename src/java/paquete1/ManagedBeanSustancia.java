package paquete1;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanSustancia")
@Dependent
// Clase que representa las sustancias
    public  class ManagedBeanSustancia {
        
        public ManagedBeanSustancia(){
            
        }
        
        String nombre;
        String cantidad;
        String unidad;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCantidad() {
            return cantidad;
        }

        public void setCantidad(String cantidad) {
            this.cantidad = cantidad;
        }

        public String getUnidad() {
            return unidad;
        }

        public void setUnidad(String unidad) {
            this.unidad = unidad;
        }   
        
    }