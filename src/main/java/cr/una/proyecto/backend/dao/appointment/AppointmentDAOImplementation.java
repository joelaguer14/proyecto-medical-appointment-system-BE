package cr.una.proyecto.backend.dao.appointment;

import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Appointment;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of AppoitnmentDAOImplementation class
 */
@SuppressWarnings("ALL")
public class AppointmentDAOImplementation implements AppointmentDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     *
     * @throws DAOException, DAO exception
     */
    public AppointmentDAOImplementation() throws DAOException {

    }

    /**
     * Find all the appointment in the database
     *
     * @return appointmentList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Appointment> findAll() throws DAOException {
        List<Appointment> appointmentList;
        appointmentList = session.createQuery("from Appointment", Appointment.class).list();
        return appointmentList;
    }

    /**
     * Find the appoitnment that match with the id
     *
     * @param id, identify of the Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    @Override
    public Appointment findById(int id) throws DAOException {
        Appointment appointment;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Appointment> query = builder.createQuery(Appointment.class);
        Root<Appointment> root = query.from(Appointment.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        appointment = (Appointment) q.getSingleResult();
        return appointment;
    }

    /**
     * Save a new appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    @Override
    public Appointment save(Appointment appointment) throws DAOException {
        session.beginTransaction();
        session.save(appointment);
        session.getTransaction().commit();
        return appointment;
    }

    /**
     * Update an appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    @Override
    public Appointment update(Appointment appointment) throws DAOException {
        session.beginTransaction();
        session.update(appointment);
        session.getTransaction().commit();
        return appointment;
    }

    /**
     * Delete an appointment in the database
     *
     * @param id, identify of the appointment
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException {
        Appointment appointment;
        session.beginTransaction();
        appointment = session.get(Appointment.class, id);
        session.delete(appointment);
        session.getTransaction().commit();
        return true;
    }
}