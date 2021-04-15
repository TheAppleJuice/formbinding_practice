package se.lexicon.formbinding_practice.converter;

import org.springframework.stereotype.Component;
import se.lexicon.formbinding_practice.dto.CustomerDetailsDto;
import se.lexicon.formbinding_practice.dto.CustomerDto;
import se.lexicon.formbinding_practice.entity.Customer;
import se.lexicon.formbinding_practice.entity.CustomerDetails;

import java.util.Collection;

@Component
public class CustomerDetailsConverter implements Converter<CustomerDetails, CustomerDetailsDto>{
    @Override
    public CustomerDetails toModel(CustomerDetailsDto dto) {
        return null;
    }

    @Override
    public CustomerDetailsDto toDTO(CustomerDetails model) {
        return null;
    }

    @Override
    public Collection<CustomerDetails> toModels(Collection<CustomerDetailsDto> collection) {
        return null;
    }

    @Override
    public Collection<CustomerDetailsDto> toDTos(Collection<CustomerDetails> collection) {
        return null;
    }
}
