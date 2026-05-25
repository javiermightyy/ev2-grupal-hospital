package com.hospital.demo.repository;

import com.hospital.demo.model.entity.box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface boxRepository extends JpaRepository<box, Long> {
}