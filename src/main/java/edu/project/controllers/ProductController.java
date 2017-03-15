package edu.project.controllers;

import edu.project.domain.Product;
import edu.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marango on 17/02/2017.
 *
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product/list")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }


    /**
     * This method allows to get a product from an URL parameter, using the @PathVariable annotation to assign
     * the parameter to the id variable.
     * @param id
     * @param model
     * @return URL of the specified product
     */
    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/productform";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "product/productform";
    }


    /**
     * This method allows to save or update a product. This method is called when the HTTP POST method is used
     * within the 'product' URL.
     * @param product
     * @return redirection url for the given product
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}
