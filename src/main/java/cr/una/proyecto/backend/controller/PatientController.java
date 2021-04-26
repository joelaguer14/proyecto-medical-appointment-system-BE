package cr.una.proyecto.backend.controller;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Patient;
import cr.una.proyecto.backend.service.patient.PatientServiceInterface;
import cr.una.proyecto.backend.service.patient.PatientServiceInterfaceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of PatientController class
 */
@Controller
@RequestMapping(value = "/api/patients")
public class PatientController {
    private static final Logger logger = LogManager.getLogger(PatientController.class);
    private final PatientServiceInterface patientService = new PatientServiceInterfaceImplementation();

    /**
     * Find all the patients in the database
     *
     * @return patientList
     */
    @GetMapping()
    @ResponseBody
    public List<Patient> findAll() {
        logger.info("GET -> findAll");
        List<Patient> patientList = null;
        try {
            patientList = patientService.findAll();
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return patientList;
    }

    /**
     * Find the patient that match with the id
     *
     * @param id, identify of the patient
     * @return patient
     */
    @GetMapping("{id}")
    @ResponseBody
    public Patient findById(@PathVariable int id) {
        logger.info("GET -> findById");
        Patient patient = null;
        try {
            patient = patientService.findById(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return patient;
    }

    /**
     * Save a new patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Patient save(@RequestBody Patient patient) {
        logger.info("POST -> save");
        Patient patientSaved = null;
        try {
            patientSaved = patientService.save(patient);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return patientSaved;
    }

    /**
     * Update a patient in the database
     *
     * @param patient, the entity of Patient
     * @return patient
     */
    @PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Patient update(@RequestBody Patient patient, @PathVariable int id) {
        logger.info("PUT -> update");
        Patient patientUpdated = null;
        try {
            patientUpdated = patientService.update(patient, id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return patientUpdated;
    }

    /**
     * Delete a patient in the database
     *
     * @param id, identify of the patient
     * @return isDeleted
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        logger.info("DELETE -> delete");
        boolean isDeleted = false;
        try {
            isDeleted = patientService.delete(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return isDeleted;
    }
}
