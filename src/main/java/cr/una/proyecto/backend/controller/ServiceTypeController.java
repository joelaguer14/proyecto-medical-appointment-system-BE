package cr.una.proyecto.backend.controller;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;

import cr.una.proyecto.backend.model.ServiceType;
import cr.una.proyecto.backend.service.serviceType.ServiceTypeServiceImplementation;
import cr.una.proyecto.backend.service.serviceType.ServiceTypeServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of ServiceTypeController class
 */
@Controller
@RequestMapping(value = "/api/serviceTypes")
public class ServiceTypeController {
    private static final Logger logger = LogManager.getLogger(cr.una.proyecto.backend.controller.ServiceTypeController.class);
    private final ServiceTypeServiceInterface serviceTypeService = new ServiceTypeServiceImplementation();

    /**
     * Find all the serviceTypes in the database
     *
     * @return serviceTypesList
     */
    @GetMapping()
    @ResponseBody
    public List<ServiceType> findAll() {
        logger.info("GET -> findAll");
        List<ServiceType> serviceTypeList = null;
        try {
            serviceTypeList = serviceTypeService.findAll();
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return serviceTypeList;
    }
}
