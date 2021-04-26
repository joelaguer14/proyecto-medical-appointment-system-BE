package cr.una.proyecto.backend.dao.disease;

import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Disease;

import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DiseaseDAOInterface interface
 */
public interface DiseaseDAOInterface {

    /**
     * Find all the diseases in the database
     *
     * @return diseaseList
     * @throws DAOException, DAO exception
     */
    List<Disease> findAll() throws DAOException;

    /**
     * Find the disease that match with the id
     *
     * @param id, identify of the disease
     * @return disease
     * @throws DAOException, DAO exception
     */
    Disease findById(int id) throws DAOException;

    /**
     * Save a new disease in the database
     *
     * @param disease, the entity of Disease
     * @return disease
     * @throws DAOException, DAO exception
     */
    Disease save(Disease disease) throws DAOException;

    /**
     * Update a disease in the database
     *
     * @param disease, the entity of Address
     * @return disease
     * @throws DAOException, DAO exception
     */
    Disease update(Disease disease) throws DAOException;

    /**
     * Delete an disease in the database
     *
     * @param id, identify of the disease
     * @return true
     * @throws DAOException, DAO exception
     */
    boolean delete(int id) throws DAOException;
}
