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

/**
 * Created by Marango on 11/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles({"jpadao"})
public class UserServiceJpaDaoImplTest {

    private UserService userService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User();

        user.setUsername("username");
        user.setPassword("myPassword");

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getEncryptedPassword() != null;

        System.out.println("Encrypted Password: " + savedUser.getEncryptedPassword());
    }

    @Test
    public void testSaveOfUserWithCustomer() throws Exception {

        User user = new User();

        user.setUsername("test");
        user.setPassword("12345678");

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");

        user.setCustomer(customer);

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getVersion() != null;
        assert savedUser.getCustomer() != null;
        assert savedUser.getCustomer().getId() != null;
    }
}
