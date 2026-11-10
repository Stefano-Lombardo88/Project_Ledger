package com.example.project_ledger.service;

import com.example.project_ledger.exception.SpesaNonTrovataException;
import com.example.project_ledger.model.Spesa;
import com.example.project_ledger.repository.SpesaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SpesaService {

    private final SpesaRepository spesaRepository;

    public SpesaService(SpesaRepository spesaRepository) {
        this.spesaRepository = spesaRepository;
    }

    public Spesa aggiungiSpesa(Spesa spesa) {
        return spesaRepository.save(spesa);
    }

    public BigDecimal calcolaTotale() {
        List<Spesa> spese = spesaRepository.findAll();
        BigDecimal totale = spese.stream()
                .map(Spesa::getImporto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totale;
    }

    public List<Spesa> getSpeseList() {
        return spesaRepository.findAll();
    }

    public void rimuoviSpesa(Long idSpesa) {
        Spesa spesa = getSpesaById(idSpesa);
        spesaRepository.delete(spesa);
    }

    public Spesa getSpesaById(Long idSpesa) {
        return spesaRepository.findById(idSpesa)
                .orElseThrow(() -> new SpesaNonTrovataException("Spesa con id " + idSpesa + " non trovata"));
    }
}
