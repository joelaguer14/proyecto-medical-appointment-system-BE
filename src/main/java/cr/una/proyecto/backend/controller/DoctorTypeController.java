package cr.una.proyecto.backend.controller;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;

import cr.una.proyecto.backend.model.DoctorType;
import cr.una.proyecto.backend.service.doctorType.DoctorTypeServiceImplementation;
import cr.una.proyecto.backend.service.doctorType.DoctorTypeServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/doctorTypes")
public class DoctorTypeController {
    private static final Logger logger = LogManager.getLogger(cr.una.proyecto.backend.controller.DoctorTypeController.class);
    private final DoctorTypeServiceInterface doctorService = new DoctorTypeServiceImplementation();

    /**
     * Find all the doctorTypes in the database
     *
     * @return doctorTypesList
     */
    @GetMapping()
    @ResponseBody
    public List<DoctorType> findAll() {
        logger.info("GET -> findAll");
        List<DoctorType> doctorList = null;
        try {
            doctorList = doctorService.findAll();
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorList;
    }
}
