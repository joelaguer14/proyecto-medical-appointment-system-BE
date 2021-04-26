package cr.una.proyecto.backend.dao.disease;

import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Disease;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of DiseaseDAOImplementation class
 */
@SuppressWarnings("ALL")
public class DiseaseDAOImplementation implements DiseaseDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     *
     * @throws DAOException, DAO exception
     */
    public DiseaseDAOImplementation() throws DAOException {

    }

    /**
     * Find all the diseases in the database
     *
     * @return diseaseList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Disease> findAll() throws DAOException {
        List<Disease> diseaseList;
        diseaseList = session.createQuery("from Disease", Disease.class).list();
        return diseaseList;
    }

    /**
     * Find the disease that match with the id
     *
     * @param id, identify of the disease
     * @return disease
     * @throws DAOException, DAO exception
     */
    @Override
    public Disease findById(int id) throws DAOException {
        Disease disease;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Disease> query = builder.createQuery(Disease.class);
        Root<Disease> root = query.from(Disease.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        disease = (Disease) q.getSingleResult();
        return disease;
    }

    /**
     * Save a new disease in the database
     *
     * @param disease, the entity of Disease
     * @return disease
     * @throws DAOException, DAO exception
     */
    @Override
    public Disease save(Disease disease) throws DAOException {
        session.beginTransaction();
        session.save(disease);
        session.getTransaction().commit();
        return disease;
    }

    /**
     * Update a disease in the database
     *
     * @param disease, the entity of Address
     * @return disease
     * @throws DAOException, DAO exception
     */
    @Override
    public Disease update(Disease disease) throws DAOException {
        session.beginTransaction();
        session.update(disease);
        session.getTransaction().commit();
        return disease;
    }

    /**
     * Delete an disease in the database
     *
     * @param id, identify of the disease
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException {
        Disease disease;
        session.beginTransaction();
        disease = session.get(Disease.class, id);
        session.delete(disease);
        session.getTransaction().commit();
        return true;
    }
}
