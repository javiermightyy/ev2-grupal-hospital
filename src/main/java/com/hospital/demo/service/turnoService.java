package com.hospital.demo.service;

import com.hospital.demo.dto.request.turnoRequestDTO;
import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.turno;
import com.hospital.demo.repository.turnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class turnoService {

    private final turnoRepository repositorio;

    // Aquí transformamos el DTO en una Entidad real
    public turno guardar(turnoRequestDTO dto) {
        turno nuevaEntidad = turno.builder()
                .rutEmpleado(dto.getRutEmpleado())
                .area(dto.getArea())
                .inicioTurno(dto.getInicioTurno())
                .finTurno(dto.getFinTurno())
                .build();
                
        return repositorio.save(nuevaEntidad);
    }

    public turno obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró el turno con ID: " + id));
    }

    public List<turno> listarTodos() {
        return repositorio.findAll();
    }
}