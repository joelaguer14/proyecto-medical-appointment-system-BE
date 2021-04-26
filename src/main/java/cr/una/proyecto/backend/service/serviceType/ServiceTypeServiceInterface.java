package cr.una.proyecto.backend.service.serviceType;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.ServiceType;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of ServiceTypeServiceImplementation interface
 */
public interface ServiceTypeServiceInterface {
    /**
     * Find all the service types in the database
     *
     * @return servicesList
     * @throws DAOException, DAO exception
     */
    List<ServiceType> findAll() throws DAOException, ServiceException;

    /**
     * Return the cost of a service type
     *
     * @return cost
     */
    float cost (ServiceType serviceType) throws DAOException, ServiceException;
}