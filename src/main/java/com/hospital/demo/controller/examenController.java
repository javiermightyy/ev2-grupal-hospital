package com.hospital.demo.controller;

import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.examen;
import com.hospital.demo.service.examenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/examenes")
@RequiredArgsConstructor
public class examenController {

    private final examenService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<examen>> crear(@RequestBody examen entidad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Examen creado exitosamente", servicio.guardar(entidad)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<examen>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Examen encontrado", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<examen>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de exámenes", servicio.listarTodos()));
    }
}