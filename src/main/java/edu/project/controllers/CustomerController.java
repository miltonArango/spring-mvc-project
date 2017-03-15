package edu.project.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.project.domain.Customer;
import edu.project.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marango on 18/02/2017.
 *
 */
@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/show/{id}")
    public String getCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/show/" + savedCustomer.getId();
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerform";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
