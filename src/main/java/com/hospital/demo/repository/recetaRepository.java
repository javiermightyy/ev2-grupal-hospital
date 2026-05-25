package com.hospital.demo.repository;

import com.hospital.demo.model.entity.receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface recetaRepository extends JpaRepository<receta, Long> {
}