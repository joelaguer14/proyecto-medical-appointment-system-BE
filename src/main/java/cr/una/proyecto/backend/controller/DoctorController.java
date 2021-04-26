package cr.una.proyecto.backend.controller;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Doctor;
import cr.una.proyecto.backend.service.doctor.DoctorServiceImplementation;
import cr.una.proyecto.backend.service.doctor.DoctorServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DoctorController class
 */
@Controller
@RequestMapping(value = "/api/doctors")
public class DoctorController {
    private static final Logger logger = LogManager.getLogger(cr.una.proyecto.backend.controller.DoctorController.class);
    private final DoctorServiceInterface doctorService = new DoctorServiceImplementation();

    public DoctorController() throws DAOException {
    }

    /**
     * Find all the doctor in the database
     *
     * @return doctorList
     */
    @GetMapping()
    @ResponseBody
    public List<Doctor> findAll() {
        logger.info("GET -> findAll");
        List<Doctor> doctorList = null;
        try {
            doctorList = doctorService.findAll();
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorList;
    }

    /**
     * Find the doctor that match with the id
     *
     * @param id, identify of the doctor
     * @return doctor
     */
    @GetMapping("{id}")
    @ResponseBody
    public Doctor findById(@PathVariable int id) {
        logger.info("GET -> findById");
        Doctor doctor = null;
        try {
            doctor = doctorService.findById(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctor;
    }

    /**
     * Save a new doctor in the database
     *
     * @param doctorOffice, the entity of Doctor
     * @return doctor
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Doctor save(@RequestBody Doctor doctorOffice) {
        logger.info("POST -> save");
        Doctor doctorSaved = null;
        try {
            doctorSaved = doctorService.save(doctorOffice);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorSaved;
    }

    /**
     * Update a doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     */
    @PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Doctor update(@RequestBody Doctor doctor, @PathVariable int id) {
        logger.info("GET -> update");
        Doctor doctorUpdated = null;
        try {
            doctorUpdated = doctorService.update(doctor, id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return doctorUpdated;
    }

    /**
     * Delete a doctor in the database
     *
     * @param id, identify of the doctor
     * @return isDeleted
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        logger.info("DELETE -> delete");
        boolean isDeleted = false;
        try {
            isDeleted = doctorService.delete(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return isDeleted;
    }
}
