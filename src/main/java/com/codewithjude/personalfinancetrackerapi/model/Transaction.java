package com.codewithjude.personalfinancetrackerapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Use of lombok annotations
@Data // Generates getters, setters, toString, etc.
@NoArgsConstructor  // Generates the empty constructor Jackson needs
@AllArgsConstructor // Generates the constructor with all fields

public class Transaction {
    private Long id;
    private Double amount;
    private String description;
    private TransactionType type;
    private LocalDate timestamp = LocalDate.now();

}
