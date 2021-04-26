package cr.una.proyecto.backend.dao.serviceType;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.ServiceType;
import cr.una.proyecto.backend.model.Id;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of ServiceDAOInterface interface
 */
public interface ServiceTypeDAOInterface {
    /**
     * Find all the service in the database
     *
     * @return serviceList
     * @throws DAOException, DAO exception
     */
    List<ServiceType> findAll() throws DAOException;

    /**
     * Find the service that match with the id
     *
     * @param id, identify of the service
     * @return service
     * @throws DAOException, DAO exception
     */
    ServiceType findById(Id id) throws DAOException;
}