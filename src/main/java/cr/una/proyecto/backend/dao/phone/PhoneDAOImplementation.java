package cr.una.proyecto.backend.dao.phone;

import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Phone;
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
 * Implementation of PhoneDAOImplementation class
 */
@SuppressWarnings("ALL")
public class PhoneDAOImplementation implements PhoneDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     *
     * @throws DAOException, DAO exception
     */
    public PhoneDAOImplementation() throws DAOException {

    }
    /**
     * Find all the phone in the database
     *
     * @return phoneList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Phone> findAll() throws DAOException {
        List<Phone> phoneList;
        phoneList = session.createQuery("from Phone", Phone.class).list();
        return phoneList;
    }

    /**
     * Find the phone that match with the id
     *
     * @param id, identify of the phone
     * @return phone
     * @throws DAOException, DAO exception
     */
    @Override
    public Phone findById(int id) throws DAOException {
        Phone phone;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> query = builder.createQuery(Phone.class);
        Root<Phone> root = query.from(Phone.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        phone = (Phone) q.getSingleResult();
        return phone;
    }

    /**
     * Save a new phone in the database
     *
     * @param phone, the entity of Phone
     * @return phone
     * @throws DAOException, DAO exception
     */
    @Override
    public Phone save(Phone phone) throws DAOException {
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
        return phone;
    }

    /**
     * Update a phone in the database
     *
     * @param phone, the entity of Phone
     * @return patient
     * @throws DAOException, DAO exception
     */
    @Override
    public Phone update(Phone phone) throws DAOException {
        session.beginTransaction();
        session.update(phone);
        session.getTransaction().commit();
        return phone;
    }

    /**
     * Delete a phone in the database
     *
     * @param id, identify of the Phone
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException {
        Phone phone;
        session.beginTransaction();
        phone = session.get(Phone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        return true;
    }
}
