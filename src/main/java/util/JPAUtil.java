package util;

import dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static boolean isValidUser(String username, String password) {
        EntityManager entityManager = getEntityManager();
        UserDao userDao = new UserDao(entityManager);
        Boolean b = userDao.isValidUser(entityManager, username, password);
        return b;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}