package se.lexicon.formbinding_practice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
   // @Column(nullable = false)
   // @NotBlank(message = "Field can not be blank")
    private String customerId;

   // @Email(message = "Wrong email format")
   // @Column(nullable = false)
    private String email;

   // @Column(nullable = false)
    private LocalDate regDate;

    private boolean active;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;
}
