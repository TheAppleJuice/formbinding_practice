package se.lexicon.formbinding_practice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CustomerController {

    @GetMapping("/customer")
    public String showCustomer (){

        return "customer";
    }

    @GetMapping("/customerDetails")
    public String showDetails (){

        return "customerDetails";
    }
}
