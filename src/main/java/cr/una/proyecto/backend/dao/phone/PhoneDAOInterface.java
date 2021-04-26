package cr.una.proyecto.backend.dao.phone;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Phone;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of PhonrDAOInterface interface
 */
public interface PhoneDAOInterface {
    /**
     * Find all the phone in the database
     *
     * @return phoneList
     * @throws DAOException, DAO exception
     */
    List<Phone> findAll() throws DAOException;

    /**
     * Find the phone that match with the id
     *
     * @param id, identify of the phone
     * @return phone
     * @throws DAOException, DAO exception
     */
    Phone findById(int id) throws DAOException;

    /**
     * Save a new phone in the database
     *
     * @param phone, the entity of Phone
     * @return phone
     * @throws DAOException, DAO exception
     */
    Phone save(Phone phone) throws DAOException;

    /**
     * Update a phone in the database
     *
     * @param phone, the entity of Phone
     * @return patient
     * @throws DAOException, DAO exception
     */
    Phone update(Phone phone) throws DAOException;

    /**
     * Delete a phone in the database
     *
     * @param id, identify of the Phone
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}
