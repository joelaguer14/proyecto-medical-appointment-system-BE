package cr.una.proyecto.backend.dao.serviceType;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.ServiceType;
import cr.una.proyecto.backend.model.Id;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of ServiceTypeDAOImplementation class
 */
public class ServiceTypeDAOImplementation implements ServiceTypeDAOInterface {
    private static final String REST_URI = "https://api.mlab.com/api/1/databases/colegio-medicos-cr/collections/servicios?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";

    /**
     * Find all the service in the database
     *
     * @return serviceList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<ServiceType> findAll() throws DAOException {
        List<ServiceType> serviceTypeList;
        RestTemplate restTemplate = new RestTemplate();
        serviceTypeList = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(REST_URI, ServiceType[].class)));
        return serviceTypeList;
    }

    /**
     * ind the service that match with the id
     *
     * @param id, identify of the service
     * @return service
     * @throws DAOException, DAO exception
     */
    @Override
    public ServiceType findById(Id id) throws DAOException {
        List<ServiceType> serviceTypeList = findAll();
        return serviceTypeList.stream().filter(serviceType -> serviceType.getId().get$oid().equals(id.get$oid())).findFirst().orElse(null);
    }
}