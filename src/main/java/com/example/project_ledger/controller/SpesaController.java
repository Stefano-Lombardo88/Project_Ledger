package com.example.project_ledger.controller;

import com.example.project_ledger.model.Spesa;
import com.example.project_ledger.service.SpesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/spese")
    public ResponseEntity<Spesa> createSpesa(@RequestBody Spesa spesa) {
        Spesa salvata = spesaService.aggiungiSpesa(spesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvata);
    }
}
