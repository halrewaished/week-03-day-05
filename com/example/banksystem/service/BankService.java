package com.example.banksystem.service;

import com.example.banksystem.model.Bank;
import com.example.banksystem.repository.BankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

    public void addBank(Bank bank) {

        bankRepository.save(bank);
    }

}
