package se.lexicon.formbinding_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping("/")
    public String index (){
        return "index";
    }
    /*
    @GetMapping("/addCustomer")
    public String addCustomer (){
        return "customerAddForm";
    }

    @GetMapping ("/customerList")
    public String customerView (){
        return "customerManagement";
    }


    @GetMapping("/customerDetails")
    public String showDetails (){

        return "customerDetails";
    }

     */




}
