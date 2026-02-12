package com.codewithjude.personalfinancetrackerapi.presentation.controller;

import com.codewithjude.personalfinancetrackerapi.domain.entity.Transaction;
import com.codewithjude.personalfinancetrackerapi.domain.entity.TransactionType;
import com.codewithjude.personalfinancetrackerapi.application.service.TransactionService;
import com.codewithjude.personalfinancetrackerapi.presentation.dto.TransactionRequest;
import com.codewithjude.personalfinancetrackerapi.presentation.dto.TransactionResponse;
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
    public List<TransactionResponse> getAll(){
       return transactionService.getAllTransactions();
    }

    @PostMapping
    public TransactionResponse create(@RequestBody TransactionRequest request){
       return transactionService.addTransaction(request);
    }

    @GetMapping("/balance")
    public Double getBalance() {
        return transactionService.calculateNetBalance();
    }

    @GetMapping("/type/{type}")
    public List<TransactionResponse> getByType(@PathVariable TransactionType type){
        return  transactionService.getTransactionsByType(type);
    }
}
