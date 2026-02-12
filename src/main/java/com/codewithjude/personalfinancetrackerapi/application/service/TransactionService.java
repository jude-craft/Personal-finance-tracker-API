package com.codewithjude.personalfinancetrackerapi.application.service;

import com.codewithjude.personalfinancetrackerapi.domain.entity.Transaction;
import com.codewithjude.personalfinancetrackerapi.domain.entity.TransactionType;
import com.codewithjude.personalfinancetrackerapi.presentation.dto.TransactionRequest;
import com.codewithjude.personalfinancetrackerapi.presentation.dto.TransactionResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service  // Tells Spring to manage this class as a bean
public class TransactionService {

    // Temporary in memory storage for week 1
    private final List<Transaction> transactions = new ArrayList<>();
    private Long nextId = 1L;

    public List<TransactionResponse> getAllTransactions() {

        return transactions.stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TransactionResponse addTransaction(TransactionRequest request) {
        // Maps DTO to Entity
        Transaction transaction = new Transaction();
        transaction.setId(nextId++);
        transaction.setDescription(request.description());
        transaction.setAmount(request.amount());
        transaction.setType(request.type());
        transaction.setTimestamp(LocalDate.now());

        // Save
        transactions.add(transaction);

        // Map entity -> Response DTO
        return mapToResponse(transaction);
    }

    public Double calculateNetBalance() {
        return transactions.stream()
                .mapToDouble(t -> t.getType() == TransactionType.INCOME ? t.getAmount() : -t.getAmount())
                .sum();
    }

    public List<TransactionResponse> getTransactionsByType(TransactionType type) {
        return transactions.stream()
                .filter(t -> t.getType() == type)
                .map(this::mapToResponse) // Convert to DTO
                .toList();
    }

    // Helper methods to keep code clean
    private TransactionResponse mapToResponse(Transaction transaction){
        return new TransactionResponse(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getTimestamp()
        );
    }

}
