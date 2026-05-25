package com.hospital.demo.repository;

import com.hospital.demo.model.entity.medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface medicamentoRepository extends JpaRepository<medicamento, Long> {
}