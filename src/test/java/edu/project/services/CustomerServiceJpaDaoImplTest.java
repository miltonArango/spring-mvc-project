package edu.project.services;

import edu.project.config.JpaIntegrationConfig;
import edu.project.domain.Customer;
import edu.project.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Marango on 10/03/2017.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles({"jpadao"})
public class CustomerServiceJpaDaoImplTest {

    private CustomerService customerService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Test
    public void testListMethod() throws Exception {
        List<Customer> customers = (List<Customer>) customerService.listAll();
        assert customers.size() == 3;
    }

    @Test
    public void testGetById() throws Exception {
        Integer id = 1;
        Customer returnedCustomer = customerService.getById(id);
        assert returnedCustomer.getId() == id;
    }

    @Test
    public void testSave() throws Exception {

        Customer testCustomer = new Customer();

        testCustomer.setFirstName("Test");
        testCustomer.setLastName("Client");
        testCustomer.setPhone("555-23323");
        testCustomer.setEmail("castle@mail.com");
        testCustomer.setState("FL");
        testCustomer.setCity("Miami");
        testCustomer.setZipCode("339009");
        testCustomer.setAddress1("MURDER ST");
        testCustomer.setAddress2("EAST AVE.");

        customerService.saveOrUpdate(testCustomer);

        assert customerService.listAll().size() == 4;
    }

    @Test
    public void testUpdate() throws Exception {
        Integer id = 1;
        String testFirstName = "Test";

        Customer sampleCustomer = customerService.getById(id);
        sampleCustomer.setFirstName(testFirstName);

        customerService.saveOrUpdate(sampleCustomer);

        assert customerService.getById(id).getFirstName().equals(testFirstName);
    }

    @Test
    public void testDelete() throws Exception {
        Integer id = 1;
        customerService.delete(id);
        assert customerService.listAll().size() == 2;
    }

    @Test
    public void testSaveWithUser() {

        Customer customer = new Customer();
        User user = new User();
        user.setUsername("This is my user name");
        user.setPassword("MyAwesomePassword");
        customer.setUser(user);

        Customer savedCustomer = customerService.saveOrUpdate(customer);

        assert savedCustomer.getUser().getId() != null;
    }
}
