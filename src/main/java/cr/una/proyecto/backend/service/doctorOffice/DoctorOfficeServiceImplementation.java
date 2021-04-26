package cr.una.proyecto.backend.service.doctorOffice;

import cr.una.proyecto.backend.dao.doctorOffice.DoctorOfficeDAOImplementation;
import cr.una.proyecto.backend.dao.doctorOffice.DoctorOfficeDAOInterface;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.DoctorOffice;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 * <p>
 * Implementation of DoctorOfficeServiceImplementation class
 */
public class DoctorOfficeServiceImplementation implements DoctorOfficeServiceInterface {
    private DoctorOfficeDAOInterface doctorOfficeDAO = new DoctorOfficeDAOImplementation();

    /**
     * Default constructor
     */
    public DoctorOfficeServiceImplementation() throws DAOException {

    }

    /**
     * Find all the doctor offices in the database
     *
     * @return doctorOfficeList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<DoctorOffice> findAll() throws DAOException, ServiceException {
        List<DoctorOffice> doctorOfficeList;
        doctorOfficeList = doctorOfficeDAO.findAll();
        return doctorOfficeList;
    }

    /**
     * Find the doctorOffice that match with the id
     *
     * @param id, identify of the doctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    @Override
    public DoctorOffice findById(int id) throws DAOException, ServiceException {
        DoctorOffice doctorOffice;
        doctorOffice = doctorOfficeDAO.findById(id);
        return doctorOffice;
    }

    /**
     * Save a new doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    @Override
    public DoctorOffice save(DoctorOffice doctorOffice) throws DAOException, ServiceException {
        DoctorOffice doctorOfficeSaved;
        doctorOfficeSaved = doctorOfficeDAO.save(doctorOffice);
        return doctorOfficeSaved;
    }

    /**
     * Update a doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    @Override
    public DoctorOffice update(DoctorOffice doctorOffice, int id) throws DAOException, ServiceException {
        DoctorOffice doctorOfficeUpdated;
        DoctorOffice updatedDoctorOffice = doctorOfficeDAO.findById(id);
        updatedDoctorOffice.setName(doctorOffice.getName());
        if(validateDoctorOfficeDays(doctorOffice.getDays())){
            updatedDoctorOffice.setDays(doctorOffice.getDays());
        }
        updatedDoctorOffice.setHour(doctorOffice.getHour());
        updatedDoctorOffice.getAddresses().clear();
        updatedDoctorOffice.getAddresses().addAll(doctorOffice.getAddresses());
        updatedDoctorOffice.getPhones().clear();
        updatedDoctorOffice.getPhones().addAll(doctorOffice.getPhones());

        doctorOfficeUpdated = doctorOfficeDAO.update(updatedDoctorOffice);
        return doctorOfficeUpdated;
    }

    /**
     * Delete a doctorOffice in the database
     *
     * @param id, identify of the doctorOffice
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException, ServiceException {
        return doctorOfficeDAO.delete(id);
    }


    /**
     * Validates the Doctor office days to make sure that the user don't type an
     * invalid word. It'll throw an exception if the Text is not valid or does not
     * contain any day of the week.
     *
     * @param days text of days to validate.
     * @throws Exception if the text doesn't have a valid day.
     */
    public boolean validateDoctorOfficeDays(String days) throws ServiceException {
        if (!(days.contains("MONDAY") || days.contains("TUESDAY") || days.contains("WEDNESDAY") || days.contains("THURSDAY")
                || days.contains("FRIDAY") || days.contains("SATURDAY") || days.contains("SUNDAY")))
            throw new ServiceException("Invalid day");
        else return true;
    }
}
