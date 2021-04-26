package cr.una.proyecto.backend.service.doctorType;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Doctor;
import cr.una.proyecto.backend.model.DoctorType;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorTypeServiceImplementation interface
 */
public interface DoctorTypeServiceInterface {
    /**
     * Find all the doctor types in the database
     *
     * @return doctorTypesList
     * @throws DAOException, DAO exception
     */
    List<DoctorType> findAll() throws DAOException, ServiceException;
}

