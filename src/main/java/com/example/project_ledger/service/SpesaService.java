package com.example.project_ledger.service;

import com.example.project_ledger.model.Spesa;
import com.example.project_ledger.repository.SpesaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SpesaService {

    private final SpesaRepository spesaRepository;

    public SpesaService(SpesaRepository spesaRepository) {
        this.spesaRepository = spesaRepository;
    }

    public void aggiungiSpesa(Spesa spesa) {
        spesaRepository.save(spesa);
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

    public Spesa rimuoviSpesa(Long idSpesa) {
        Spesa spesaRimossa = null;
        Optional<Spesa> risultato = spesaRepository.findById(idSpesa);
        if (risultato.isPresent()){
            spesaRimossa = risultato.get();
            spesaRepository.deleteById(idSpesa);
        }
        return spesaRimossa;
    }
}
