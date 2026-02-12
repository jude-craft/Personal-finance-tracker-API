package com.codewithjude.personalfinancetrackerapi.presentation.dto;

import com.codewithjude.personalfinancetrackerapi.domain.entity.TransactionType;

public record TransactionRequest(
        String description,
        Double amount,
        TransactionType type
) {
}
