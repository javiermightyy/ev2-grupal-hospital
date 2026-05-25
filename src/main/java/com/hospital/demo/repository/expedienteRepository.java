package com.hospital.demo.repository;

import com.hospital.demo.model.entity.expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface expedienteRepository extends JpaRepository<expediente, Long> {
}