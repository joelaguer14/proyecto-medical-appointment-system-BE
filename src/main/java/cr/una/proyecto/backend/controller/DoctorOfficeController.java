package cr.una.proyecto.backend.controller;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.DoctorOffice;
import cr.una.proyecto.backend.service.doctorOffice.DoctorOfficeServiceImplementation;
import cr.una.proyecto.backend.service.doctorOffice.DoctorOfficeServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorOfficeController class
 */
@Controller
@RequestMapping(value = "/api/doctorOffices")
public class DoctorOfficeController {
    private static final Logger logger = LogManager.getLogger(DoctorOfficeController.class);
    private final DoctorOfficeServiceInterface doctorOfficeService = new DoctorOfficeServiceImplementation();

    public DoctorOfficeController() throws DAOException {
    }

    /**
     * Find all the doctor offices in the database
     *
     * @return doctorOfficeList
     */
    @GetMapping()
    @ResponseBody
    public List<DoctorOffice> findAll() {
        logger.info("GET -> findAll");
        List<DoctorOffice> doctorOfficeList = null;
        try {
            doctorOfficeList = doctorOfficeService.findAll();
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorOfficeList;
    }

    /**
     * Find the doctorOffice that match with the id
     *
     * @param id, identify of the doctorOffice
     * @return doctorOffice
     */
    @GetMapping("{id}")
    @ResponseBody
    public DoctorOffice findById(@PathVariable int id) {
        logger.info("GET -> findById");
        DoctorOffice doctorOffice = null;
        try {
            doctorOffice = doctorOfficeService.findById(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorOffice;
    }

    /**
     * Save a new doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public DoctorOffice save(@RequestBody DoctorOffice doctorOffice) {
        logger.info("POST -> save");
        DoctorOffice doctorOfficeSaved = null;
        try {
            doctorOfficeSaved = doctorOfficeService.save(doctorOffice);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorOfficeSaved;
    }

    /**
     * Update a doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     */
    @PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public DoctorOffice update(@RequestBody DoctorOffice doctorOffice, @PathVariable int id) {
        logger.info("GET -> update");
        DoctorOffice doctorOfficeUpdated = null;
        try {
            doctorOfficeUpdated = doctorOfficeService.update(doctorOffice, id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorOfficeUpdated;
    }

    /**
     * Delete a doctorOffice in the database
     *
     * @param id, identify of the doctorOffice
     * @return isDeleted
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        logger.info("DELETE -> delete");
        boolean isDeleted = false;
        try {
            isDeleted = doctorOfficeService.delete(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return isDeleted;
    }
}