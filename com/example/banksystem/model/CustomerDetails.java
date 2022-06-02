package com.example.banksystem.model;

import com.example.banksystem.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class CustomerDetails {

    @Id
    @NotNull(message = "Id is required !")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Age is required !")
    private Integer age;
    @NotNull(message = "Balance is required !")
    private Integer balance;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
