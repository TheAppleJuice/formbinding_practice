package se.lexicon.formbinding_practice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false)
    private String detailsId;

    @NotNull
    private String street;


    @NotNull
    private String zipCode;

    //@Column(nullable = false)
    private String city;

    //@Column(nullable = false)
    private String homePhone;

    // @Column(nullable = false)
    private String cellPhone;
}
