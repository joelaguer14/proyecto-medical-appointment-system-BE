package cr.una.proyecto.backend.service.patient;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Patient;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of PatientServiceInterface interface
 */
public interface PatientServiceInterface {
    /**
     * Find all the patients in the database
     *
     * @return patientList
     * @throws DAOException, DAO exception
     */
    List<Patient> findAll() throws DAOException, ServiceException;

    /**
     * Find the patient that match with the id
     *
     * @param id, identify of the patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    Patient findById(int id) throws DAOException, ServiceException;

    /**
     * Save a new patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    Patient save(Patient patient) throws DAOException, ServiceException;

    /**
     * Update a patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    Patient update(Patient patient, int id) throws DAOException, ServiceException;

    /**
     * Delete a patient in the database
     *
     * @param id, identify of the patient
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException, ServiceException;
}
