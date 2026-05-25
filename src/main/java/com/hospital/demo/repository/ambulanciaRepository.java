package com.hospital.demo.repository;

import com.hospital.demo.model.entity.ambulancia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ambulanciaRepository extends JpaRepository<ambulancia, Long> {
}