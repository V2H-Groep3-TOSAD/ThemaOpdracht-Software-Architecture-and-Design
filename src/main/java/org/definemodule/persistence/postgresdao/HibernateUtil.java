package org.definemodule.persistence.postgresdao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static String postgres = "hibernate.postgres";
    private static String postgresTarget = "hibernate.postgres.target";
    private static final EntityManagerFactory entityManagerFactory;
    private static final EntityManagerFactory entityManagerFactoryTarget;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(postgres);
            entityManagerFactoryTarget = Persistence.createEntityManagerFactory(postgresTarget);
        }
        catch (Throwable th) {
            System.err.println("Initial EntityManagerFactory creation failed"
                    + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManagerFactory getEntityManagerFactoryTarget() {
        return entityManagerFactoryTarget;
    }

}
