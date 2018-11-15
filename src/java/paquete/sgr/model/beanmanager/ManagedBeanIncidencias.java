package paquete.sgr.model.beanmanager;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
/**
 *
 * @author iron1
 */
@Named(value = "Incidencias")
@RequestScoped
public class ManagedBeanIncidencias {

    /**
     * Creates a new instance of ManagedBeanIncidencias
     */
    public ManagedBeanIncidencias() {
    }

    private Part file; // +getter+setter

    public void save() {
      
    }

}
