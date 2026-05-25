package com.hospital.demo.service;

import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.hora;
import com.hospital.demo.repository.horaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class horaService {

    private final horaRepository repositorio;

    public hora guardar(hora entidad) {
        return repositorio.save(entidad);
    }

    public hora obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró la hora médica con ID: " + id));
    }

    public List<hora> listarTodos() {
        return repositorio.findAll();
    }
}