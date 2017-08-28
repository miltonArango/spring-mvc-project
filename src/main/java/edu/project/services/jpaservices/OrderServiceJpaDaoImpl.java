package edu.project.services.jpaservices;

import edu.project.domain.ProductOrder;
import edu.project.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Marango on 19/03/2017.
 *
 */
@Service
@Profile("jpadao")
public class OrderServiceJpaDaoImpl extends AbstractJpaDaoService implements OrderService {

    @Override
    public List<ProductOrder> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Order", ProductOrder.class).getResultList();
    }

    @Override
    public ProductOrder getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(ProductOrder.class, id);
    }

    @Override
    public ProductOrder saveOrUpdate(ProductOrder domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ProductOrder savedProduct = em.merge(domainObject);
        em.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(ProductOrder.class, id));
        em.getTransaction().commit();
    }
}
