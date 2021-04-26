package cr.una.proyecto.backend.service.serviceType;

import cr.una.proyecto.backend.dao.serviceType.ServiceTypeDAOImplementation;
import cr.una.proyecto.backend.dao.serviceType.ServiceTypeDAOInterface;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.DoctorType;
import cr.una.proyecto.backend.model.ServiceType;
import cr.una.proyecto.backend.service.doctorType.DoctorTypeServiceImplementation;
import cr.una.proyecto.backend.service.doctorType.DoctorTypeServiceInterface;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 * <p>
 * Implementation of ServiceTypeServiceImplementation class
 */
public class ServiceTypeServiceImplementation implements ServiceTypeServiceInterface {
    private ServiceTypeDAOInterface serviceTypeDAO;

    /**
     * Default constructor
     */
    public ServiceTypeServiceImplementation() {

    }

    /**
     * Find all the service in the database
     *
     * @return serviceList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<ServiceType> findAll() throws DAOException, ServiceException {
        List<ServiceType> serviceTypeList;
        serviceTypeDAO = new ServiceTypeDAOImplementation();
        serviceTypeList = serviceTypeDAO.findAll();
        return serviceTypeList;
    }

    /**
     * Return the cost of a service type
     *
     * @return cost
     */
    @Override
    public float cost(ServiceType serviceType) throws ServiceException, DAOException {
        DoctorTypeServiceInterface doctorTypeService = new DoctorTypeServiceImplementation();

        if (serviceType.getPercentageCost() != null) {
            float percentageCost = Float.parseFloat(serviceType.getPercentageCost()) / 100;
            float totalCost = 0;
            for (DoctorType doctorType : doctorTypeService.findAll()) {
                if ("G-1".equals(serviceType.getMedicalCode()) && "G-1".equals(doctorType.getMedicalCode())) {
                    totalCost= percentageCost * Float.parseFloat(doctorType.getSalary());
                } else if ("G-2".equals(serviceType.getMedicalCode()) && "G-2".equals(doctorType.getMedicalCode())) {
                    totalCost= percentageCost * Float.parseFloat(doctorType.getSalary());
                }
            }
            return totalCost;
        } else {
            return Float.parseFloat(serviceType.getCost());
        }
    }
}
