package cr.una.proyecto.backend.dao.doctorOffice;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.DoctorOffice;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorOfficeDAOInterface interface
 */
public interface DoctorOfficeDAOInterface {
    /**
     * Find all the doctor offices in the database
     *
     * @return doctorOfficeList
     * @throws DAOException, DAO exception
     */
    List<DoctorOffice> findAll() throws DAOException;

    /**
     * Find the doctorOffice that match with the id
     *
     * @param id, identify of the doctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    DoctorOffice findById(int id) throws DAOException;

    /**
     * Save a new doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    DoctorOffice save(DoctorOffice doctorOffice) throws DAOException;

    /**
     * Update a doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    DoctorOffice update(DoctorOffice doctorOffice) throws DAOException;

    /**
     * Delete a doctorOffice in the database
     *
     * @param id, identify of the doctorOffice
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}
