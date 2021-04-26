package cr.una.proyecto.backend.dao.doctorOffice;

import cr.una.proyecto.backend.dao.HibernateUtil;
import cr.una.proyecto.backend.exception.DAOException;
import cr.una.proyecto.backend.model.DoctorOffice;
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
 * Implementation of DoctorOfficeDAOImplementation class
 */
public class DoctorOfficeDAOImplementation implements DoctorOfficeDAOInterface {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Default constructor
     *
     * @throws DAOException, DAO exception
     */
    public DoctorOfficeDAOImplementation() throws DAOException {

    }

    /**
     * Find all the doctor offices in the database
     *
     * @return doctorOfficeList
     * @throws DAOException, DAO exception
     */
    @Override
    public List<DoctorOffice> findAll() throws DAOException {
        List<DoctorOffice> doctorOfficeList;
        doctorOfficeList = session.createQuery("from DoctorOffice", DoctorOffice.class).list();
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
    public DoctorOffice findById(int id) throws DAOException {
        DoctorOffice doctorOffice;
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<DoctorOffice> query = builder.createQuery(DoctorOffice.class);
        Root<DoctorOffice> root = query.from(DoctorOffice.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query q = session.createQuery(query);
        doctorOffice = (DoctorOffice) q.getSingleResult();
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
    public DoctorOffice save(DoctorOffice doctorOffice) throws DAOException {
        session.beginTransaction();
        session.save(doctorOffice);
        session.getTransaction().commit();
        return doctorOffice;
    }

    /**
     * Update a doctorOffice in the database
     *
     * @param doctorOffice, the entity of DoctorOffice
     * @return doctorOffice
     * @throws DAOException, DAO exception
     */
    @Override
    public DoctorOffice update(DoctorOffice doctorOffice) throws DAOException {
        session.beginTransaction();
        session.update(doctorOffice);
        session.getTransaction().commit();
        return doctorOffice;
    }

    /**
     * Delete an doctorOffice in the database
     *
     * @param id, identify of the doctorOffice
     * @return true
     * @throws DAOException, DAO exception
     */
    @Override
    public boolean delete(int id) throws DAOException {
        DoctorOffice doctorOffice;
        session.beginTransaction();
        doctorOffice = session.get(DoctorOffice.class, id);
        session.delete(doctorOffice);
        session.getTransaction().commit();
        return true;
    }
}
