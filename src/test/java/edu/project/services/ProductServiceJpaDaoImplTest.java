package edu.project.services;

import edu.project.config.JpaIntegrationConfig;
import edu.project.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Marango on 07/03/2017.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles({"jpadao"})
public class ProductServiceJpaDaoImplTest {

    private ProductService productService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void testListMethod() throws Exception {
        List<Product> products = (List<Product>) productService.listAll();
        assert products.size() == 5;
    }

    @Test
    public void testGetById() throws Exception {
        Integer id = 1;
        Product returnedProduct = productService.getById(id);
        assert returnedProduct.getId() == id;
    }

    @Test
    public void testSave() throws Exception {
        Product testProduct = new Product();

        testProduct.setDescription("Test Description");
        testProduct.setPrice(new BigDecimal("15.99"));
        testProduct.setImageUrl("sample");

        productService.saveOrUpdate(testProduct);

        assert productService.listAll().size() == 6;
    }

    @Test
    public void testUpdate() throws Exception {
        Integer id = 1;
        String testDescription = "Test";

        Product sampleProduct = productService.getById(id);
        sampleProduct.setDescription(testDescription);

        productService.saveOrUpdate(sampleProduct);

        assert productService.getById(id).getDescription().equals(testDescription);
    }

    @Test
    public void testDelete() throws Exception {
        Integer id = 1;
        productService.delete(id);
        assert productService.listAll().size() == 4;
    }
}
