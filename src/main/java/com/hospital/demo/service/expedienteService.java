package com.hospital.demo.service;

import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.expediente;
import com.hospital.demo.repository.expedienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class expedienteService {

    private final expedienteRepository repositorio;

    public expediente guardar(expediente entidad) {
        return repositorio.save(entidad);
    }

    public expediente obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró el expediente con ID: " + id));
    }

    public List<expediente> listarTodos() {
        return repositorio.findAll();
    }
}