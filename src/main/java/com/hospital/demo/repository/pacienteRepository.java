package com.hospital.demo.repository;

import com.hospital.demo.model.entity.paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface pacienteRepository extends JpaRepository<paciente, Long> {
    Optional<paciente> findByRut(Integer rut);
}