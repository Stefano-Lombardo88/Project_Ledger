package com.example.project_ledger.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NuovaSpesaRequest(
        @NotBlank
        String descrizione,
        @NotNull
        LocalDate data,
        @Positive @NotNull
        BigDecimal importo
) {}
