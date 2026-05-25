package com.hospital.demo.service;

import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.box;
import com.hospital.demo.repository.boxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class boxService {

    private final boxRepository repositorio;

    public box guardar(box entidad) {
        return repositorio.save(entidad);
    }

    public box obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró el box con ID: " + id));
    }

    public List<box> listarTodos() {
        return repositorio.findAll();
    }
}