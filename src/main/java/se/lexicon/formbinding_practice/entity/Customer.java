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
    @Column(nullable = false)
    @NotNull
    private String customerId;

    @Email(message = "Wrong email format")
    @NotNull
    private String email;

    @NotNull
    private LocalDate regDate;

    @Column(columnDefinition = "tinyint(1) default 1")
    @NotNull
    private boolean active;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;
}
