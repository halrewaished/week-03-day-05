package com.example.banksystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Bank {

    @Id
    @NotNull(message = "Id is required !")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name is required !")
    private String name;

    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
    private Set<Customer> customer;
}
