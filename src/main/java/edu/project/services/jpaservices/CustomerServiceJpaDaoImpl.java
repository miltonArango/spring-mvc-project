package edu.project.services.jpaservices;

import edu.project.domain.Customer;
import edu.project.services.CustomerService;
import edu.project.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Marango on 08/03/2017.
 *
 */

@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl extends AbstractJpaDaoService implements CustomerService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<Customer> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        if (domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject.getUser().setEncryptedPassword(
                    encryptionService.encryptString(domainObject.getUser().getPassword()));
        }

        Customer savedCustomer = em.merge(domainObject);
        em.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Customer.class, id));
        em.getTransaction().commit();

    }
}
