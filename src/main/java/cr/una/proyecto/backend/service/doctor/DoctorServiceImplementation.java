package cr.una.proyecto.backend.service.doctor;

import cr.una.proyecto.backend.dao.doctor.DoctorDAOImplementation;
import cr.una.proyecto.backend.dao.doctor.DoctorDAOInterface;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.exception.ServiceException;
import cr.una.proyecto.backend.model.Doctor;

import java.util.List;

public class DoctorServiceImplementation implements DoctorServiceInterface{
    private DoctorDAOInterface doctorDAO= new DoctorDAOImplementation();;

    /**
     * Default constructor
     */
    public DoctorServiceImplementation() throws DAOException {

    }

    /**
     * Find all the doctor  in the database
     *
     * @return doctorList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Doctor> findAll() throws DAOException, ServiceException {
        List<Doctor> doctorList;
        doctorList = doctorDAO.findAll();
        return doctorList;
    }

    /**
     * Find the doctor that match with the id
     *
     * @param id, identify of the doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    @Override
    public Doctor findById(int id) throws DAOException, ServiceException {
        Doctor doctor;
        doctor = doctorDAO.findById(id);
        return doctor;
    }

    /**
     * Save a new doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    @Override
    public Doctor save(Doctor doctor) throws DAOException, ServiceException {
        Doctor doctorSaved;
        doctorSaved = doctorDAO.save(doctor);
        return doctorSaved;
    }

    /**
     * Update a doctor in the database
     *
     * @param doctor, the entity of Doctor
     * @return doctor
     * @throws DAOException, DAO exception
     */
    @Override
    public Doctor update(Doctor doctor, int id) throws DAOException, ServiceException {
        Doctor doctorUpdated;
        Doctor updatedDoctor = doctorDAO.findById(id);
        updatedDoctor.setName(doctor.getName());
        updatedDoctor.setPremium(doctor.getPremium());
        updatedDoctor.setMedicalCode(doctor.getMedicalCode());

        doctorUpdated = doctorDAO.update(updatedDoctor);
        return doctorUpdated;
    }

    /**
     * Delete a doctor in the database
     *
     * @param id, identify of the doctor
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException, ServiceException {
        return doctorDAO.delete(id);
    }
}
