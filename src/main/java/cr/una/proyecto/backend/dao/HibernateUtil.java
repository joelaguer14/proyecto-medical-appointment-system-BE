package cr.una.proyecto.backend.dao;

import cr.una.proyecto.backend.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of HibernateUtil class
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    /**
     * Class utils for connection to the database using Hibernate
     *
     * @return sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/medicalsystemappointment");
                settings.put(Environment.USER, "medicalsystemappointment");
                settings.put(Environment.PASS, "1234$una");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");

                // IMPORTANT HBM2DDL_AUTO +++++++++++++
                // validate: validate the schema, makes no changes to the database.
                // update: update the schema.
                // create: creates the schema, destroying previous data.
                // create-drop: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.
                // none: does nothing with the schema, makes no changes to the database

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Patient.class);
                configuration.addAnnotatedClass(Disease.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(DoctorOffice.class);
                configuration.addAnnotatedClass(Doctor.class);
                configuration.addAnnotatedClass(Appointment.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
