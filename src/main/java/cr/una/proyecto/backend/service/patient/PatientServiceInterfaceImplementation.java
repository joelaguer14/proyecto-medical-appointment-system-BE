package cr.una.proyecto.backend.service.patient;

import cr.una.proyecto.backend.dao.patient.PatientDAOImplementation;
import cr.una.proyecto.backend.dao.patient.PatientDAOInterface;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Patient;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of PatientServiceImplementation class
 */
public class PatientServiceInterfaceImplementation implements PatientServiceInterface {
    private PatientDAOInterface patientDAO=new PatientDAOImplementation();;

    /**
     * Default constructor
     */
    public PatientServiceInterfaceImplementation() {

    }

    /**
     * Find all the patients in the database
     *
     * @return patientList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Patient> findAll() throws DAOException, ServiceException {
        List<Patient> patientList;
        patientList = patientDAO.findAll();
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
    public Patient findById(int id) throws DAOException, ServiceException {
        Patient patient;
        patient = patientDAO.findById(id);
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
    public Patient save(Patient patient) throws DAOException, ServiceException {
        Patient patientSaved;
        patientSaved = patientDAO.save(patient);
        return patientSaved;
    }

    /**
     * Update a patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     * @throws DAOException, DAO exception
     */
    @Override
    public Patient update(Patient patient, int id) throws DAOException, ServiceException {
        Patient patientUpdated;
        Patient updatedPatient = patientDAO.findById(id);
        updatedPatient.setFullName(patient.getFullName());
        updatedPatient.setBirthDate(patient.getBirthDate());
        updatedPatient.setObservations(patient.getObservations());
        updatedPatient.getDiseases().clear();
        updatedPatient.getDiseases().addAll(patient.getDiseases());
        updatedPatient.getAddresses().clear();
        updatedPatient.getAddresses().addAll(patient.getAddresses());
        updatedPatient.getPhones().clear();
        updatedPatient.getPhones().addAll(patient.getPhones());

        patientUpdated = patientDAO.update(updatedPatient);
        return patientUpdated;
    }

    /**
     * Delete a patient in the database
     *
     * @param id, identify of the patient
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException, ServiceException {
        return patientDAO.delete(id);
    }
}