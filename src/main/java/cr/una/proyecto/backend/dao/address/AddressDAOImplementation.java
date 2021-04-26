
package cr.una.proyecto.backend.dao.address;

import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.Address;
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
 * Implementation of AddressDAOImplementation class
 */
@SuppressWarnings("ALL")
public class AddressDAOImplementation implements AddressDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     *
     * @throws DAOException, DAO exception
     */
    public AddressDAOImplementation() throws DAOException {

    }

    /**
     * Find all the addresses in the database
     *
     * @return addressList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<Address> findAll() throws DAOException {
        List<Address> addressList;
        addressList = session.createQuery("from Address", Address.class).list();
        return addressList;
    }

    /**
     * Find the address that match with the id
     *
     * @param id, identify of the address
     * @return address
     * @throws DAOException, DAO exception
     */
    @Override
    public Address findById(int id) throws DAOException {
        Address address;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> root = query.from(Address.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        address = (Address) q.getSingleResult();
        return address;
    }

    /**
     * Save a new address in the database
     *
     * @param address, the entity of Address
     * @return address
     * @throws DAOException, DAO exception
     */
    @Override
    public Address save(Address address) throws DAOException {
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        return address;
    }

    /**
     * Update an address in the database
     *
     * @param address, the entity of Address
     * @return address
     * @throws DAOException, DAO exception
     */
    @Override
    public Address update(Address address) throws DAOException {
        session.beginTransaction();
        session.update(address);
        session.getTransaction().commit();
        return address;
    }

    /**
     * Delete an address in the database
     *
     * @param id, identify of the address
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException {
        Address address;
        session.beginTransaction();
        address = session.get(Address.class, id);
        session.delete(address);
        session.getTransaction().commit();
        return true;
    }
}
