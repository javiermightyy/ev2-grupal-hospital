package com.hospital.demo.service;

import com.hospital.demo.dto.request.medicamentoRequestDTO;
import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.medicamento;
import com.hospital.demo.repository.medicamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class medicamentoService {

    private final medicamentoRepository repositorio;

    public medicamento guardar(medicamentoRequestDTO dto) {
        medicamento nuevaEntidad = medicamento.builder()
                .nombre(dto.getNombre())
                .principioActivo(dto.getPrincipioActivo())
                .stockDisponible(dto.getStockDisponible())
                .build();
                
        return repositorio.save(nuevaEntidad);
    }

    public medicamento obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró el medicamento con ID: " + id));
    }

    public List<medicamento> listarTodos() {
        return repositorio.findAll();
    }
}