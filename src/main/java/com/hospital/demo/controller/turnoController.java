package com.hospital.demo.controller;

import com.hospital.demo.dto.request.turnoRequestDTO;
import com.hospital.demo.dto.Response.apiResponse; // <-- Corregido aquí
import com.hospital.demo.model.entity.turno;
import com.hospital.demo.service.turnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/turnos")
@RequiredArgsConstructor
public class turnoController {

    private final turnoService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<turno>> crear(@RequestBody turnoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Turno creado exitosamente", servicio.guardar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<turno>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Turno encontrado", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<turno>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de turnos", servicio.listarTodos()));
    }
}