package cr.una.proyecto.backend.dao.doctorType;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.DoctorType;
import cr.una.proyecto.backend.model.Id;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorTypeDAOInterface interface
 */
public interface DoctorTypeDAOInterface {
    /**
     * Find all the doctor tupes in the database
     *
     * @return doctorTypeList
     * @throws DAOException, DAO exception
     */
    List<DoctorType> findAll() throws DAOException;

    /**
     * Find the doctorType that match with the id
     *
     * @param id, identify of the doctorType
     * @return doctorType
     * @throws DAOException, DAO exception
     */
    DoctorType findById(Id id) throws DAOException;
}
