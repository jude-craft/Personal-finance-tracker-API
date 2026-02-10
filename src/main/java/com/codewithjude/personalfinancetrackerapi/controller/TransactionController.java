package com.codewithjude.personalfinancetrackerapi.controller;

import com.codewithjude.personalfinancetrackerapi.model.Transaction;
import com.codewithjude.personalfinancetrackerapi.model.TransactionType;
import com.codewithjude.personalfinancetrackerapi.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    // Constructor Injection (DI)
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getTransaction(){
       return transactionService.getAllTransactions();
    }

    @PostMapping
    public String createTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
        return "Transaction added successfully";

    }

    @GetMapping("/balance")
    public Double getBalance() {
        return transactionService.calculateNetBalance();
    }

    @GetMapping("/type/{type}")
    public List<Transaction> getByType(@PathVariable TransactionType type){
        return  transactionService.getTransactionsByType(type);
    }
}
