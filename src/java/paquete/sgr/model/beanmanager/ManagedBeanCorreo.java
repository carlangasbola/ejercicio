package paquete.sgr.model.beanmanager;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import paquete.sgr.beans.ConsultasHQL;
import paquete.sgr.beans.Correo;

/**
 *
 * @author iron1
 */
@Named(value = "managedBeanCorreo")
@RequestScoped
public class ManagedBeanCorreo {
    
    private String correo;
    private String mensaje;
   
    /**
     * Creates a new instance of ManagedBeanCorreo
     */
    public ManagedBeanCorreo() {
    }
    
    public void enviarCorreo(){
         Mensajes msj = new Mensajes();
        Correo email = new Correo();
        ConsultasHQL consulta = new ConsultasHQL();
        Session s = consulta.obtenerSession();
        
        Query q = s.createQuery("Select usuarios.passsword FROM DatosUsuario where correo = :correo ").setParameter("correo", this.correo);
        
        List<String> lista = q.list();
        
        String from = "cbolanoshernandez3@gmail.com";
        String pass = "ZEn7NzESP7MRfExn";
        String[] to = { this.correo }; // list of recipient email addresses
        String subject = "Restablecimiento de contraseña";
        // Manda null tenemos que corregir eso
        String body = "Esta es tu contraseña, por favor guardala bien " + lista 
                    + " En caso de algún error contacte al administrador del sistema";

        email.sendFromGMail(from, pass, to, subject, body);
        
        msj.setTitulo("Mensaje del sistema");
        msj.setMensaje("Se ha realizado tu petición, verifica tu correo eléctronico");
        msj.MensajeInfo();
    }
    
    public void enviarMensaje(){
        Mensajes msj = new Mensajes();
        Correo email = new Correo();
        String from = "cbolanoshernandez3";
        String pass = "ZEn7NzESP7MRfExn";
        String[] to = { "cbolanoshernandez3@gmail.com" }; // list of recipient email addresses
        String subject = "Comentario para la mejora del sistema";
        // Manda null tenemos que corregir eso
        String body = mensaje;

        email.sendFromGMail(from, pass, to, subject, body);
        
        msj.setTitulo("Mensaje del sistema");
        msj.setMensaje("Se envio correctamente tu mensaje");
        msj.MensajeInfo();
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
