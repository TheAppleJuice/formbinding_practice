package se.lexicon.formbinding_practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.formbinding_practice.converter.CustomerConverter;
import se.lexicon.formbinding_practice.dto.CustomerDetailsDto;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;
import se.lexicon.formbinding_practice.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class customerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerConverter customerConverter;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    public void setCustomerConverter(CustomerConverter customerConverter) {
        this.customerConverter = customerConverter;
    }


    @Override
    public CustomerDto saveOrUpdate(CustomerDto customerDto) {
        if (customerDto == null) throw new IllegalArgumentException("CustomerDto is not valid");
        Customer convertDtoToModel = customerConverter.toModel(customerDto);
        Customer savedObject = customerRepository.save(convertDtoToModel);
        return customerConverter.toDTO(savedObject);
    }

    @Override
    public List<CustomerDto> getAll() {
        Iterable<Customer> iterable = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        iterable.iterator().forEachRemaining(customerList::add);
        System.out.println(customerList);

        /*List<CustomerDto> testDebug = new ArrayList<>();
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
        return testDebug;*/
        return new ArrayList<>(customerConverter.toDTos(customerList));
    }

    @Override
    //TODO: Kolla över så att metoden fungerar med String id.
    public CustomerDto findByCustomerId(String id) {
        if (id == null)
            throw new IllegalArgumentException("Customer id can not be null"); //TODO: Can vara något fel med if satsen för en "String"
        Customer customer = customerRepository.findById(id).orElse(null);
        return customerConverter.toDTO(customer);
    }
}
