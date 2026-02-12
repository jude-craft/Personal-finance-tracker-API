package com.codewithjude.personalfinancetrackerapi.presentation.dto;

import com.codewithjude.personalfinancetrackerapi.domain.entity.TransactionType;

import java.time.LocalDate;

public record TransactionResponse(
        Long id,
        String description,
        Double amount,
        TransactionType type,
        LocalDate timestamp
){}
