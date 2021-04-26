package cr.una.proyecto.backend.service.doctorType;

import cr.una.proyecto.backend.dao.doctorType.DoctorTypeDAOImplementation;
import cr.una.proyecto.backend.dao.doctorType.DoctorTypeDAOInterface;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.DoctorType;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of ServiceTypeServiceImplementation class
 */
public class DoctorTypeServiceImplementation implements DoctorTypeServiceInterface {
    private DoctorTypeDAOInterface doctorTypeDAO= new DoctorTypeDAOImplementation();

    /**
     * Default constructor
     */
    public DoctorTypeServiceImplementation() {

    }

    /**
     * Find all the doctor  in the database
     *
     * @return doctorList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<DoctorType> findAll() throws DAOException, ServiceException {
        List<DoctorType> doctorTypeList;
        doctorTypeList = doctorTypeDAO.findAll();
        return doctorTypeList;
    }
}
