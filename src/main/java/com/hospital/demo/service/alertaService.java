package com.hospital.demo.service;

import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.alerta;
import com.hospital.demo.repository.alertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class alertaService {

    private final alertaRepository repositorio;

    public alerta guardar(alerta entidad) {
        return repositorio.save(entidad);
    }

    public alerta obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró la alerta con ID: " + id));
    }

    public List<alerta> listarTodos() {
        return repositorio.findAll();
    }
}