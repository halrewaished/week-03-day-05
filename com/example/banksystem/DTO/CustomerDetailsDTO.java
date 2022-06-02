package com.example.banksystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class CustomerDetailsDTO {

    private Integer customerId;
    private Integer age;
    private Integer balance;
}
