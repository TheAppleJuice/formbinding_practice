package se.lexicon.formbinding_practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.formbinding_practice.dto.CustomerDetailsDto;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;
import se.lexicon.formbinding_practice.entity.CustomerDetails;
import se.lexicon.formbinding_practice.service.CustomerService;

import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer/view")
public class CustomerManagementController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<CustomerDto> testDebug = new ArrayList<>();
        CustomerDto testCustomer = new CustomerDto();
        testCustomer.setCustomerId("test1");
        testCustomer.setEmail("sb@test.se");
        testCustomer.setActive(true);
        testCustomer.setRegDate(LocalDate.now());

        CustomerDetailsDto testDetailsDto = new CustomerDetailsDto();
        testDetailsDto.setDetailsId("test2");
        testDetailsDto.setCellPhone("12345678");
        testDetailsDto.setHomePhone("12345678");
        testDetailsDto.setCity("Växjö");
        testDetailsDto.setZipCode("12345");
        testDetailsDto.setStreet("street 1a");


        testCustomer.setCustomerDetailsDto(testDetailsDto);
        testDebug.add(testCustomer);
        //TODO: problem in converter
        model.addAttribute("customerDtoList", testDebug);
        return "customerManagement";
    }

    @GetMapping("/find/{id}")
    public String getCustomerById(@PathVariable("id") String id, Model model) {
        System.out.println("Id = " + id);
        CustomerDto optionalCustomerDto = customerService.findByCustomerId(id);
        model.addAttribute("customerDto", optionalCustomerDto);
        return "customerDetails";
    }

    @GetMapping("/addCustomerForm")
    public String registerForm(Model model) {
        CustomerDto customerDtoRegisterForm = new CustomerDto();
        model.addAttribute("customerDtoRegisterForm", customerDtoRegisterForm);
        return "customerAddForm";
    }

    @PostMapping("/add")
    //TODO: @Valid före CustomerDto
    public String addCustomerToDb(@ModelAttribute("customerDtoRegisterForm") CustomerDto customerDto,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "customerAddForm";
        }

        customerService.saveOrUpdate(customerDto);
        redirectAttributes.addFlashAttribute("message", "Add customer email: " + customerDto.getEmail() + " is done");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/customer/view/list";
    }
}
