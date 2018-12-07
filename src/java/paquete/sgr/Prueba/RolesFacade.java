
package paquete.sgr.Prueba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RolesFacade extends AbstractFacade<Roles> {

    @PersistenceContext(unitName = "ProyectoFinalTT2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }

}
