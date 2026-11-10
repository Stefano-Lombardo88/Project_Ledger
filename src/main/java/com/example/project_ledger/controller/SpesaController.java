package com.example.project_ledger.controller;

import com.example.project_ledger.dto.NuovaSpesaRequest;
import com.example.project_ledger.model.Spesa;
import com.example.project_ledger.service.SpesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/spese/{id}")
    public Spesa getSpesa(@PathVariable Long id) {
        return spesaService.getSpesaById(id);
    }

    @PostMapping("/spese")
    public ResponseEntity<Spesa> createSpesa(@RequestBody NuovaSpesaRequest spesaDto) {
        Spesa spesa = new Spesa(spesaDto.descrizione(), spesaDto.data(), spesaDto.importo());
        Spesa salvata = spesaService.aggiungiSpesa(spesa);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvata.getIdSpesa())
                .toUri();
        return ResponseEntity.created(location).body(salvata);
    }

    @DeleteMapping("/spese/{id}")
    public ResponseEntity<Void> deleteSpesa(@PathVariable Long id) {
        spesaService.rimuoviSpesa(id);
        return ResponseEntity.noContent().build();
    }
}