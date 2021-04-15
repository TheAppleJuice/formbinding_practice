package se.lexicon.formbinding_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String showCustomer (){
        return "customer";
    }
/*
    @GetMapping("/customerDetails")
    public String showDetails (){

        return "customerDetails";
    }

 */
}
