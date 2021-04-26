package cr.una.proyecto.backend.dao.doctorType;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.DoctorType;
import cr.una.proyecto.backend.model.Id;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorTypeDAOImplementation class
 */
public class DoctorTypeDAOImplementation implements DoctorTypeDAOInterface {
    private static final String REST_URI = "https://api.mlab.com/api/1/databases/colegio-medicos-cr/collections/tipomedicos?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";

    /**
     * Find all the doctor tupes in the database
     *
     * @return doctorTypeList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<DoctorType> findAll() throws DAOException {
        List<DoctorType> doctorTypeList;
        RestTemplate restTemplate = new RestTemplate();
        doctorTypeList = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(REST_URI, DoctorType[].class)));
        return doctorTypeList;
    }

    /**
     * ind the doctorType that match with the id
     *
     * @param id, identify of the doctorType
     * @return doctorType
     * @throws DAOException, DAO exception
     */
    @Override
    public DoctorType findById(Id id) throws DAOException {
        List<DoctorType> doctorTypeList = findAll();
        return doctorTypeList.stream().filter(doctorType -> doctorType.getId().get$oid().equals(id.get$oid())).findFirst().orElse(null);
    }
}
