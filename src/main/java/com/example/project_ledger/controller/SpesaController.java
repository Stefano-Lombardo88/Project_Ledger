package com.example.project_ledger.controller;

import com.example.project_ledger.model.Spesa;
import com.example.project_ledger.service.SpesaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpesaController {
    private final SpesaService spesaService;

    public SpesaController(SpesaService spesaService) {
        this.spesaService = spesaService;
    }

    @GetMapping("/spese")
    public List<Spesa> getSpese() {
        return spesaService.getSpeseList();
    }

}
