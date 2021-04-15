package se.lexicon.formbinding_practice.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;

import java.util.Collection;

@Component
public class CustomerConverter implements Converter <Customer, CustomerDto> {

    CustomerDetailsConverter customerDetailsConverter;

    @Autowired
    public void setCustomerDetailsConverter(CustomerDetailsConverter customerDetailsConverter) {
        this.customerDetailsConverter = customerDetailsConverter;
    }


    @Override
    public Customer toModel(CustomerDto dto) {
        return null;
    }

    @Override
    public CustomerDto toDTO(Customer model) {
        return null;
    }

    @Override
    public Collection<Customer> toModels(Collection<CustomerDto> collection) {
        return null;
    }

    @Override
    public Collection<CustomerDto> toDTos(Collection<Customer> collection) {
        return null;
    }
}
