package edu.project.bootstrap;

import edu.project.domain.Customer;
import edu.project.domain.Product;
import edu.project.services.CustomerService;
import edu.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Marango on 05/03/2017.
 *
 *
 */
@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private ProductService productService;
    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }

    public void loadProducts(){

        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }

    public void loadCustomers(){

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

        customerService.saveOrUpdate(customer1);

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

        customerService.saveOrUpdate(customer2);

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

        customerService.saveOrUpdate(customer3);

    }
}
