package se.lexicon.formbinding_practice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDate;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String customerId;
    private String email;
    private LocalDate regDate;
    private boolean active;
    private CustomerDetails customerDetails;
}
