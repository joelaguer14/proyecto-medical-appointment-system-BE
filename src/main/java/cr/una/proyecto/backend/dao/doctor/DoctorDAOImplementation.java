package cr.una.proyecto.backend.dao.doctor;

import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Doctor;
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
 * Implementation of DoctorDAOImplementation class
 */
public class DoctorDAOImplementation implements DoctorDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     *
     * @throws DAOException, DAO exception
     */
    public DoctorDAOImplementation() throws DAOException {

    }

    /**
     * Find all the doctor in the database
     *
     * @return doctorList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Doctor> findAll() throws DAOException {
        List<Doctor> doctorList;
        doctorList = session.createQuery("from Doctor", Doctor.class).list();
        return doctorList;
    }

    /**
     * Find the doctor that match with the id
     *
     * @param id, identify of the doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    @Override
    public Doctor findById(int id) throws DAOException {
        Doctor doctor;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
        Root<Doctor> root = query.from(Doctor.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        doctor = (Doctor) q.getSingleResult();
        return doctor;
    }

    /**
     * Save a new doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    @Override
    public Doctor save(Doctor doctor) throws DAOException {
        session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();
        return doctor;
    }

    /**
     * Update a doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    @Override
    public Doctor update(Doctor doctor) throws DAOException {
        session.beginTransaction();
        session.update(doctor);
        session.getTransaction().commit();
        return doctor;
    }

    /**
     * Delete an doctor in the database
     *
     * @param id, identify of the doctor
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException {
        Doctor doctor;
        session.beginTransaction();
        doctor = session.get(Doctor.class, id);
        session.delete(doctor);
        session.getTransaction().commit();
        return true;
    }
}
