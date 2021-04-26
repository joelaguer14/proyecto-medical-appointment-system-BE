package cr.una.proyecto.backend.dao.patient;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Patient;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of PatientDAOInterface interface
 */
public interface PatientDAOInterface {
    /**
     * Find all the patients in the database
     *
     * @return patientList
     * @throws DAOException, DAO exception
     */
    List<Patient> findAll() throws DAOException;

    /**
     * Find the patient that match with the id
     *
     * @param id, identify of the patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    Patient findById(int id) throws DAOException;

    /**
     * Save a new patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    Patient save(Patient patient) throws DAOException;

    /**
     * Update a patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    Patient update(Patient patient) throws DAOException;

    /**
     * Delete a patient in the database
     *
     * @param id, identify of the patient
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}
