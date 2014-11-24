package br.fafiman.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fernando
 */
public class JPAUtils {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeConnection() {
        emf.close();
    }
}
