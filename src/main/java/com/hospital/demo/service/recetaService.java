package com.hospital.demo.service;

import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.receta;
import com.hospital.demo.repository.recetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class recetaService {

    private final recetaRepository repositorio;

    public receta guardar(receta entidad) {
        return repositorio.save(entidad);
    }

    public receta obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró la receta con ID: " + id));
    }

    public List<receta> listarTodos() {
        return repositorio.findAll();
    }
}