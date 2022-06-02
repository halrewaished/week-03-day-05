package com.example.banksystem.controller;

import com.example.banksystem.DTO.Api;
import com.example.banksystem.DTO.CustomerDetailsDTO;
import com.example.banksystem.exception.CustomerFoundsException;
import com.example.banksystem.model.CustomerDetails;
import com.example.banksystem.service.CustomerDetailsService;
import com.example.banksystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer-details")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;
    private final CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomerDetails(){
        logger.info("Request in get customer details ");
        return ResponseEntity.status(200).body(customerDetailsService.getCustomerDetails());
    }

    @PostMapping("/details")
    public ResponseEntity<Api> addCustomerDetails(@RequestBody CustomerDetailsDTO cd){
        logger.info("Request in add customer details ");
        customerDetailsService.addCustomerDetails(cd);
        return ResponseEntity.status(200).body(new Api("Customer added !",201));
    }

    @PostMapping("/withdraws")
    public ResponseEntity<Api> withdraw(@RequestBody CustomerDetailsDTO cd, @PathVariable Integer amount)
            throws CustomerFoundsException {
        logger.info("Request in withdraws ");
        customerService.withdraw(cd,amount);
        return ResponseEntity.status(200).body(new Api(" Withdrawn successfully !",201));
    }
    @PostMapping("/deposits/{amount}")
    public ResponseEntity deposits (@RequestBody CustomerDetailsDTO cd , @PathVariable Integer amount){
        logger.info("Request in deposits ");
        customerService.deposit(cd,amount);
        return ResponseEntity.status(200).body(new Api(" Deposited successfully !",201));
    }
}
