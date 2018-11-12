
package paquete.sgr.beans;


public class Reactivos {
    
    private String nombre;
    private double cantidad;

    public Reactivos(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public Reactivos(){
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
