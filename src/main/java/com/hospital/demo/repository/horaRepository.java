package com.hospital.demo.repository;

import com.hospital.demo.model.entity.hora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface horaRepository extends JpaRepository<hora, Long> {
}