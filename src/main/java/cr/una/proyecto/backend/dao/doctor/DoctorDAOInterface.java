package cr.una.proyecto.backend.dao.doctor;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Doctor;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorDAOInterface interface
 */
public interface DoctorDAOInterface {
    /**
     * Find all the doctor in the database
     *
     * @return doctorList
     * @throws DAOException, DAO exception
     */
    List<Doctor> findAll() throws DAOException;

    /**
     * Find the doctor that match with the id
     *
     * @param id, identify of the doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    Doctor findById(int id) throws DAOException;

    /**
     * Save a new doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    Doctor save(Doctor doctor) throws DAOException;

    /**
     * Update a doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    Doctor update(Doctor doctor) throws DAOException;

    /**
     * Delete a doctor in the database
     *
     * @param id, identify of the doctor
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}
