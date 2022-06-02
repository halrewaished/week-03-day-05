package com.example.banksystem.service;

import com.example.banksystem.DTO.CustomerDetailsDTO;
import com.example.banksystem.model.Customer;
import com.example.banksystem.model.CustomerDetails;
import com.example.banksystem.repository.CustomerDetailsRepository;
import com.example.banksystem.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;
    private final CustomerRepository customerRepository;

    public List<CustomerDetails> getCustomerDetails() {

        return customerDetailsRepository.findAll();
    }

    public void addCustomerDetails(CustomerDetailsDTO cd ){
        Customer customer = customerRepository.findById(cd.getCustomerId()).get();
        CustomerDetails customerDetails = new CustomerDetails( null, cd.getAge(),
                cd.getBalance(),customer);
        customer.setCustomerDetails(customerDetails);
        customerDetailsRepository.save(customerDetails);
    }

}
