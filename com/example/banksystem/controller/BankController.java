package com.example.banksystem.controller;

import com.example.banksystem.DTO.Api;
import com.example.banksystem.model.Bank;
import com.example.banksystem.service.BankService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;
    Logger logger = LoggerFactory.getLogger(BankController.class);

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks(){
        logger.info("Request in get banks ");
        return ResponseEntity.status(200).body(bankService.getBanks());
    }

    @PostMapping
    public ResponseEntity<Api> AddBank(@RequestBody @Valid Bank bank){
        logger.info("Request in add bank ");
        bankService.addBank(bank);
        return ResponseEntity.status(200).body(new Api("Bank added !",200));
    }

}
