package cr.una.proyecto.backend.dao.address;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Address;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of AddressDAOInterface interface
 */
public interface AddressDAOInterface {
    /**
     * Find all the addresses in the database
     *
     * @return addressList
     * @throws DAOException, DAO exception
     */
    List<Address> findAll() throws DAOException;

    /**
     * Find the address that match with the id
     *
     * @param id, identify of the address
     * @return address
     * @throws DAOException, DAO exception
     */
    Address findById(int id) throws DAOException;

    /**
     * Save a new address in the database
     *
     * @param address, the entity of Address
     * @return address
     * @throws DAOException, DAO exception
     */
    Address save(Address address) throws DAOException;

    /**
     * Update an address in the database
     *
     * @param address, the entity of Address
     * @return address
     * @throws DAOException, DAO exception
     */
    Address update(Address address) throws DAOException;

    /**
     * Delete an address in the database
     *
     * @param id, identify of the address
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}
