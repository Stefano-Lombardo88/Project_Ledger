package com.example.project_ledger.repository;

import com.example.project_ledger.model.Spesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpesaRepository extends JpaRepository<Spesa, Long> {
}
