package com.example.project_ledger.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Spesa {
    private String descrizione;
    private LocalDate data;
    private BigDecimal importo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpesa;

    protected Spesa() {}

    public Spesa(String descrizione, LocalDate data, BigDecimal importo) {
        this.descrizione = descrizione;
        this.data = data;
        setImporto(importo);
    }

    public String getDescrizione() {
        return descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getImporto() {
        return importo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setImporto(BigDecimal importo) {
        if (importo == null || importo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("L'importo deve essere maggiore di zero");
        }
        this.importo = importo;
    }

    public Long getIdSpesa() {
        return idSpesa;
    }

    public void setIdSpesa(Long idSpesa) {
        this.idSpesa = idSpesa;
    }

    @Override
    public String toString() {
        return "Spesa{" +
                "idSpesa= " + idSpesa +
                ", descrizione= '" + descrizione + '\'' +
                ", data= " + data +
                ", importo= " + importo +
                '}';
    }
}
