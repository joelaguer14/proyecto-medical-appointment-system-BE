package cr.una.proyecto.backend.service.doctor;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Doctor;

import java.util.List;

public interface DoctorServiceInterface {
    /**
     * Find all the doctor in the database
     *
     * @return doctorList
     * @throws DAOException, DAO exception
     */
    List<Doctor> findAll() throws DAOException, ServiceException;

    /**
     * Find the doctor that match with the id
     *
     * @param id, identify of the doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    Doctor findById(int id) throws DAOException, ServiceException;

    /**
     * Save a new doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    Doctor save(Doctor doctor) throws DAOException, ServiceException;

    /**
     * Update a doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    Doctor update(Doctor doctor, int id) throws DAOException, ServiceException;

    /**
     * Delete a doctor in the database
     *
     * @param id, identify of the doctor
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException, ServiceException;
}
