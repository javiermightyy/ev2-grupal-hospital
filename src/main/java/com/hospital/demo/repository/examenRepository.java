package com.hospital.demo.repository;

import com.hospital.demo.model.entity.examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface examenRepository extends JpaRepository<examen, Long> {
}