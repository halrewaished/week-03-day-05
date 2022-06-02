package com.example.banksystem.controller;

import com.example.banksystem.DTO.Api;
import com.example.banksystem.DTO.CustomerDTO;
import com.example.banksystem.model.Customer;
import com.example.banksystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        logger.info("Request in get customers ");
        return ResponseEntity.status(200).body(customerService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<Api> AddCustomer(@RequestBody @Valid Customer customer){
        logger.info("Request in add customer ");
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new Api("Customer added !",200));

    }

    @PostMapping("/bank")
    public ResponseEntity<Api> addAtBank(@RequestBody CustomerDTO customerDTO){
        logger.info("Request in addAtBank ");
        customerService.addInBank(customerDTO);
        return ResponseEntity.status(200).body(new Api("Customer added in bank",200));
    }
}
