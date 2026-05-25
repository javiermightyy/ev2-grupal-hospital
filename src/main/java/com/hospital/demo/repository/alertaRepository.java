package com.hospital.demo.repository;

import com.hospital.demo.model.entity.alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface alertaRepository extends JpaRepository<alerta, Long> {
}