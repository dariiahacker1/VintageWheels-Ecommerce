package org.application.wheels.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.application.wheels.models.*;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration().configure();

                config.addAnnotatedClass(User.class);
                config.addAnnotatedClass(Car.class);
                config.addAnnotatedClass(Location.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties());

                sessionFactory = config.buildSessionFactory(builder.build());
            }

            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return sessionFactory;
    }
}
