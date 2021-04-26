package cr.una.proyecto.backend.dao.patient;


import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Patient;
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
 * Implementation of PatientDAOImplementation class
 */
@SuppressWarnings("ALL")
public class PatientDAOImplementation implements PatientDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Find all the patients in the database
     *
     * @return patientList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Patient> findAll() {
        List<Patient> patientList;
        patientList = session.createQuery("from Patient", Patient.class).list();
        return patientList;
    }

    /**
     * Find the patient that match with the id
     *
     * @param id, identify of the patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    @Override
    public Patient findById(int id) {
        Patient patient;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<Patient> root = query.from(Patient.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        patient = (Patient) q.getSingleResult();
        return patient;
    }

    /**
     * Save a new patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    @Override
    public Patient save(Patient patient) {
        session.beginTransaction();
        session.save(patient);
        session.getTransaction().commit();
        return patient;
    }

    /**
     * Update a patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    @Override
    public Patient update(Patient patient) {
        session.beginTransaction();
        session.update(patient);
        session.getTransaction().commit();
        return patient;
    }

    /**
     * Delete an patient in the database
     *
     * @param id, identify of the patient
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) {
        Patient patient;
        session.beginTransaction();
        patient = session.get(Patient.class, id);
        session.delete(patient);
        session.getTransaction().commit();
        return true;
    }
}