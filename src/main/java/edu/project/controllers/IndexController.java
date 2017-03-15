package edu.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Marango on 09/02/2017.
 * Index page controller
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
