package com.example.project_ledger.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NuovaSpesaRequest(
        String descrizione,
        LocalDate data,
        BigDecimal importo
) {}
