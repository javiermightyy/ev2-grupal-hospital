package com.hospital.demo.service;

import com.hospital.demo.dto.request.ambulanciaRequestDTO;
import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.ambulancia;
import com.hospital.demo.repository.ambulanciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ambulanciaService {

    private final ambulanciaRepository repositorio;

    public ambulancia guardar(ambulanciaRequestDTO dto) {
        ambulancia nuevaEntidad = ambulancia.builder()
                .patente(dto.getPatente())
                .tipo(dto.getTipo())                       // <-- Usa tipo()
                .estado(dto.getEstado())
                .ubicacionActual(dto.getUbicacionActual()) // <-- Usa ubicacionActual()
                .build();
                
        return repositorio.save(nuevaEntidad);
    }

    public ambulancia obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró la ambulancia con ID: " + id));
    }

    public List<ambulancia> listarTodos() {
        return repositorio.findAll();
    }
}