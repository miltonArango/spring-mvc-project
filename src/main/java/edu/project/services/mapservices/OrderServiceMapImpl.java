package edu.project.services.mapservices;

import edu.project.domain.DomainObject;
import edu.project.domain.ProductOrder;
import edu.project.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marango on 19/03/2017.
 */
@Service
@Profile("map")
public class OrderServiceMapImpl extends AbstractMapService implements OrderService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public ProductOrder getById(Integer id) {
        return (ProductOrder) super.getById(id);
    }

    @Override
    public ProductOrder saveOrUpdate(ProductOrder domainObject) {
        return (ProductOrder) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }
}
