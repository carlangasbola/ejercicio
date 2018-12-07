
package paquete.sgr.Prueba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DatosUsuarioFacade extends AbstractFacade<DatosUsuario> {

    @PersistenceContext(unitName = "ProyectoFinalTT2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatosUsuarioFacade() {
        super(DatosUsuario.class);
    }

}
