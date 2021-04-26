package cr.una.proyecto.backend.service.Appointment;

import cr.una.proyecto.backend.dao.appointment.AppointmentDAOImplementation;
import cr.una.proyecto.backend.dao.appointment.AppointmentDAOInterface;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Appointment;
import cr.una.proyecto.backend.model.DoctorOffice;
import cr.una.proyecto.backend.model.ServiceType;
import cr.una.proyecto.backend.service.serviceType.ServiceTypeServiceImplementation;
import cr.una.proyecto.backend.service.serviceType.ServiceTypeServiceInterface;

import java.util.*;

public class AppointmentServiceImplementation implements AppointmentServiceInterface {
    private AppointmentDAOInterface appointmentDAO = new AppointmentDAOImplementation();
    private final ServiceTypeServiceInterface serviceTypeService = new ServiceTypeServiceImplementation();

    /**
     * Default constructor
     */
    public AppointmentServiceImplementation() throws DAOException {

    }

    /**
     * Find all the appointment  in the database
     *
     * @return appointmentList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Appointment> findAll() throws DAOException, ServiceException {
        List<Appointment> appointmentList;
        appointmentList = appointmentDAO.findAll();
        return appointmentList;
    }

    /**
     * Find the appointment that match with the id
     *
     * @param id, identify of the appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    @Override
    public Appointment findById(int id) throws DAOException, ServiceException {
        Appointment appointment;
        appointment = appointmentDAO.findById(id);
        return appointment;
    }

    /**
     * Save a new appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    @Override
    public Appointment save(Appointment appointment) throws DAOException, ServiceException {
        Appointment appointmentSaved;
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();

        for (ServiceType serviceType : serviceTypeList) {
            if (appointment.getService().equals(serviceType.getService()) && appointment.getDoctor().getPremium()) {
                float totalCost = (serviceTypeService.cost(serviceType) * 0.10f) + serviceTypeService.cost(serviceType);
                appointment.setTotalCost(totalCost);
            } else if (appointment.getService().equals(serviceType.getService())) {
                appointment.setTotalCost(serviceTypeService.cost(serviceType));
            }
        }

        appointmentSaved = appointmentDAO.save(appointment);
        return appointmentSaved;
    }

    /**
     * Update a appointment in the database
     *
     * @param appointment, the entity of Appointment
     * @return appointment
     * @throws DAOException, DAO exception
     */
    @Override
    public Appointment update(Appointment appointment, int id) throws DAOException, ServiceException {
        Appointment appointmentUpdated;
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();

        Appointment updatedAppointment = appointmentDAO.findById(id);
        updatedAppointment.setPatient(appointment.getPatient());
        updatedAppointment.setDoctor(appointment.getDoctor());
        updatedAppointment.setDoctorOffice(appointment.getDoctorOffice());
        updatedAppointment.setDate(appointment.getDate());
        updatedAppointment.setConfirmed(appointment.isConfirmed());
        updatedAppointment.setService(appointment.getService());

        for (ServiceType serviceType : serviceTypeList) {
            if (appointment.getService().equals(serviceType.getService()) && appointment.getDoctor().getPremium()) {
                float totalCost = (serviceTypeService.cost(serviceType) * 0.10f) + serviceTypeService.cost(serviceType);
                updatedAppointment.setTotalCost(totalCost);
            } else if (appointment.getService().equals(serviceType.getService())) {
                updatedAppointment.setTotalCost(serviceTypeService.cost(serviceType));
            }
        }

        appointmentUpdated = appointmentDAO.update(updatedAppointment);
        return appointmentUpdated;
    }

    /**
     * Delete a appointment in the database
     *
     * @param id, identify of the appointment
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException, ServiceException {
        appointmentDAO = new AppointmentDAOImplementation();
        return appointmentDAO.delete(id);
    }

    /**
     * Validates the date received in the parameters for a new appointment. It will
     * throw an exception if the date is not available or if the Consulting Room is not
     * available in that day of the week.
     *
     * @param date         Appointment's date to validate.
     * @param doctorOffice appointment's consulting room
     * @throws ServiceException if the date is not valid.
     * @throws DAOException     if findAll() throws an exception.
     */
    private boolean appointmentDateValidator(Date date, DoctorOffice doctorOffice) throws ServiceException, DAOException {
        List<Appointment> appointments = findAll();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        for (Appointment appointment : appointments) {
            if (Objects.equals(date, appointment.getDate())) {
                throw new ServiceException(date.toString() + " not available");
            } else if (doctorOffice != null && !doctorOffice.getDays().contains(Integer.toString(calendar.get(Calendar.DAY_OF_WEEK)))) {
                throw new ServiceException(calendar.get(Calendar.DAY_OF_WEEK) + " not available in consulting room: " + doctorOffice.getName());
            } else if (doctorOffice != null && !(Integer.parseInt(doctorOffice.getHour().split("-")[0]) <=
                    calendar.get(Calendar.HOUR) && Integer.parseInt(doctorOffice.getHour().split("-")[1]) >= calendar.get(Calendar.HOUR))) {
                throw new ServiceException(calendar.get(Calendar.HOUR) + " not available in Doctor Office: " + doctorOffice.getName());
            }
        }
        return true;
    }
}
