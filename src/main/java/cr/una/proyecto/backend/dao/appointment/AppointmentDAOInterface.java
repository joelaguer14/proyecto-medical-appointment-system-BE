package cr.una.proyecto.backend.dao.appointment;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Appointment;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of AppointmentDAOInterface interface
 */
public interface AppointmentDAOInterface {
    /**
     * Find all the appointment in the database
     *
     * @return appointmentList
     * @throws DAOException, DAO exception
     */
    List<Appointment> findAll() throws DAOException;

    /**
     * Find the address that match with the id
     *
     * @param id, identify of the address
     * @return address
     * @throws DAOException, DAO exception
     */
    Appointment findById(int id) throws DAOException;

    /**
     * Save a new appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    Appointment save(Appointment appointment) throws DAOException;

    /**
     * Update an appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    Appointment update(Appointment appointment) throws DAOException;

    /**
     * Delete an appointment in the database
     *
     * @param id, identify of the appointment
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}