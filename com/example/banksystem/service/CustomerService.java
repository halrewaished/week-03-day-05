package com.example.banksystem.service;


import com.example.banksystem.DTO.CustomerDTO;
import com.example.banksystem.DTO.CustomerDetailsDTO;
import com.example.banksystem.exception.CustomerFoundsException;
import com.example.banksystem.exception.InvalidIdException;
import com.example.banksystem.model.Bank;
import com.example.banksystem.model.Customer;
import com.example.banksystem.model.CustomerDetails;
import com.example.banksystem.repository.BankRepository;
import com.example.banksystem.repository.CustomerDetailsRepository;
import com.example.banksystem.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public Customer getCustomerByID(Integer id){

        return customerRepository.findById(id).get();
    }

    public void withdraw(CustomerDetailsDTO cd , Integer amount)
            throws CustomerFoundsException {
        Customer customer = customerRepository.findById(cd.getCustomerId())
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
        CustomerDetails customerDetails = customerDetailsRepository.findById(cd.getCustomerId()).get();
        if(customerDetails.getBalance() < amount){
            throw new CustomerFoundsException(" customers doesnt have funds !");
        }
        else {
            customerDetails.setBalance(cd.getBalance()-amount);

        }
    }

    public void deposit(CustomerDetailsDTO cd , Integer amount)  {
        Customer customer = customerRepository.findById(cd.getCustomerId())
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
        CustomerDetails customerDetails = customerDetailsRepository.findById(cd.getCustomerId()).get();
        customerDetails.setBalance(cd.getBalance() + amount);
    }

    public void addInBank(CustomerDTO customerDTO){
        Bank bank = bankRepository.findById(customerDTO.getBankId()).get();
        Customer customer = customerRepository.findById(customerDTO.getCustomerId()).get();
        System.out.println(bank.getCustomer());
        bank.getCustomer().add(customer);
        System.out.println(bank.getCustomer());
    }


}
