package com.example.banksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Customer {

    @Id
    @NotNull(message = "Id is required !")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username is required !")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    @JsonIgnore
    private Bank bank;

}
