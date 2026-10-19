package com.example.project_ledger.service;

import com.example.project_ledger.model.Spesa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SpesaService {
    private List<Spesa> speseList = new ArrayList<>();
    private long contatore = 0;

    public void aggiungiSpesa(Spesa spesa) {
        contatore += 1;
        spesa.setIdSpesa(contatore);
        speseList.add(spesa);
    }

    public BigDecimal calcolaTotale() {
        BigDecimal totale = BigDecimal.ZERO;
        for (Spesa spesa : speseList) {
            totale = totale.add(spesa.getImporto());
        }
        return totale;
    }

    public List<Spesa> getSpeseList() {
        return speseList;
    }

    public Spesa rimuoviSpesa(Long idSpesa) {
        Spesa spesaRimossa = null;
        for (Spesa spesa : speseList) {
            if (spesa.getIdSpesa().equals(idSpesa)) {
                spesaRimossa = spesa;
                speseList.remove(spesa);
                break;
            }
        }
        return spesaRimossa;
    }
}
