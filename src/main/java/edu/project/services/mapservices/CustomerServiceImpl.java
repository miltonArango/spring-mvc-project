package edu.project.services.mapservices;

import edu.project.domain.Customer;
import edu.project.domain.DomainObject;
import edu.project.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Marango on 18/02/2017.
 * CustomerService implementation
 */
@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll(){
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id){
        super.delete(id);
    }

    @Override
    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setPhone("555-23343");
        customer1.setEmail("doe@mail.com");
        customer1.setState("FL");
        customer1.setCity("Miami");
        customer1.setZipCode("339001");
        customer1.setAddress1("BANANA ST");
        customer1.setAddress2("128 NW");

        domainMap.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");
        customer2.setPhone("555-23343");
        customer2.setEmail("jdoe@mail.com");
        customer2.setState("FL");
        customer2.setCity("Miami");
        customer2.setZipCode("339001");
        customer2.setAddress1("BANANA ST");
        customer2.setAddress2("128 NW");

        domainMap.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirstName("Frank");
        customer3.setLastName("Castle");
        customer3.setPhone("555-23323");
        customer3.setEmail("castle@mail.com");
        customer3.setState("FL");
        customer3.setCity("Miami");
        customer3.setZipCode("339009");
        customer3.setAddress1("MURDER ST");
        customer3.setAddress2("EAST AVE.");

        domainMap.put(3, customer3);
    }
}
