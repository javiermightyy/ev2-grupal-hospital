package com.hospital.demo.repository;

import com.hospital.demo.model.entity.turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface turnoRepository extends JpaRepository<turno, Long> {
}