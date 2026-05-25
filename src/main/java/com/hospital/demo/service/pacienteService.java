package com.hospital.demo.service;

import com.hospital.demo.dto.request.pacienteRequestDTO; // <-- Agregamos el import del DTO
import com.hospital.demo.exception.ResourcesNotFoundException;
import com.hospital.demo.model.entity.paciente;
import com.hospital.demo.repository.pacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class pacienteService {

    private final pacienteRepository repositorio;

    // Aquí está la magia: Recibimos el DTO y usamos el "Builder" para armar la Entidad
    public paciente guardar(pacienteRequestDTO dto) {
        paciente nuevaEntidad = paciente.builder()
                .rut(dto.getRut())
                .dv(dto.getDv())
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .fechaNacimiento(dto.getFechaNacimiento())
                .genero(dto.getGenero())
                .direccion(dto.getDireccion())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                .build();
                
        return repositorio.save(nuevaEntidad);
    }

    public paciente obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("No se encontró el paciente con ID: " + id));
    }

    public List<paciente> listarTodos() {
        return repositorio.findAll();
    }
}