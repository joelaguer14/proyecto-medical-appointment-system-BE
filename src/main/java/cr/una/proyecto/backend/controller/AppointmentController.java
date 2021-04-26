package cr.una.proyecto.backend.controller;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Appointment;
import cr.una.proyecto.backend.service.Appointment.AppointmentServiceImplementation;
import cr.una.proyecto.backend.service.Appointment.AppointmentServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of AppointmentController class
 */
@Controller
@RequestMapping(value = "/api/appointments")
public class AppointmentController {
    private static final Logger logger = LogManager.getLogger(cr.una.proyecto.backend.controller.AppointmentController.class);
    private final AppointmentServiceInterface appointmentService = new AppointmentServiceImplementation();

    public AppointmentController() throws DAOException {
    }

    /**
     * Find all the appointment in the database
     *
     * @return appointmentList
     */
    @GetMapping()
    @ResponseBody
    public List<Appointment> findAll() {
        logger.info("GET -> findAll");
        List<Appointment> appointmentList = null;
        try {
            appointmentList = appointmentService.findAll();
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return appointmentList;
    }

    /**
     * Find the appointment that match with the id
     *
     * @param id, identify of the appointment
     * @return appointment
     */
    @GetMapping("{id}")
    @ResponseBody
    public Appointment findById(@PathVariable int id) {
        logger.info("GET -> findById");
        Appointment appointment = null;
        try {
            appointment = appointmentService.findById(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return appointment;
    }

    /**
     * Save a new appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Appointment save(@RequestBody Appointment appointment) {
        logger.info("POST -> save");
        Appointment appointmentSaved = null;
        try {
            appointmentSaved = appointmentService.save(appointment);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return appointmentSaved;
    }

    /**
     * Update a appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     */
    @PutMapping(path = "{id}", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Appointment update(@RequestBody Appointment appointment, @PathVariable int id) {
        logger.info("GET -> update");
        Appointment appointmentUpdated = null;
        try {
            appointmentUpdated = appointmentService.update(appointment, id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return appointmentUpdated;
    }

    /**
     * Delete a appointment in the database
     *
     * @param id, identify of the appointment
     * @return isDeleted
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        logger.info("DELETE -> delete");
        boolean isDeleted = false;
        try {
            isDeleted = appointmentService.delete(id);
        } catch (DAOException | ServiceException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return isDeleted;
    }
}