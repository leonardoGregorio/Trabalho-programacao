package br.fafiman.negocio;

import br.fafiman.persistencia.JPAUtils;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leonardo
 * @param <T>
 */
public class GenericDAO<T> implements Serializable {

    private Class<T> classe;
    private static final Logger logger = Logger.getLogger("br.fafiman.negocio.GenericDAO");
    private EntityManager entityManager = JPAUtils.getEntityManager();

    public GenericDAO(Class<T> classe) {
        this.classe = classe;
    }

    public void persistir(T entidade) {
        try {
            getEntityManager().persist(entidade);
            commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Erro ao persistir! " + ex);
        }
    }

    public void atualizar(T entidade) {
        try {
            getEntityManager().merge(entidade);
            commit();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Erro ao atualizar! " + ex);
        }
    }

   
    private void commit() {
        getEntityManager().getTransaction().begin();
        getEntityManager().getTransaction().commit();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<T> getClasse() {
        return classe;
    }

    public Logger getLogger() {
        return logger;
    }

}
