package cr.una.proyecto.backend.service.Appointment;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Appointment;

import java.util.List;

public interface AppointmentServiceInterface {
    /**
     * Find all the appointment in the database
     *
     * @return appointmentList
     * @throws DAOException, DAO exception
     */
    List<Appointment> findAll() throws DAOException, ServiceException;

    /**
     * Find the appointment that match with the id
     *
     * @param id, identify of the appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    Appointment findById(int id) throws DAOException, ServiceException;

    /**
     * Save a new appointment in the database
     *
     * @param doctor, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    Appointment save(Appointment doctor) throws DAOException, ServiceException;

    /**
     * Update a appointment in the database
     *
     * @param doctor, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    Appointment update(Appointment doctor, int id) throws DAOException, ServiceException;

    /**
     * Delete a appointment in the database
     *
     * @param id, identify of the appointment
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException, ServiceException;
}