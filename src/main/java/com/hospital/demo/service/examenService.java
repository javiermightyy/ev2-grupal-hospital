package com.hospital.demo.service;

import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.examen;
import com.hospital.demo.repository.examenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class examenService {

    private final examenRepository repositorio;

    public examen guardar(examen entidad) {
        return repositorio.save(entidad);
    }

    public examen obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró el examen con ID: " + id));
    }

    public List<examen> listarTodos() {
        return repositorio.findAll();
    }
}