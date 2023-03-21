package br.com.onebox.app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaManager {
    private static final EntityManagerFactory entityManager = Persistence
            .createEntityManagerFactory("comex-backend");

    public static EntityManager getEntityManager() {
        return entityManager.createEntityManager();
    }
}
