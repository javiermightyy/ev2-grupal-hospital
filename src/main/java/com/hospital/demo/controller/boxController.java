package com.hospital.demo.controller;

import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.box;
import com.hospital.demo.service.boxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/boxes")
@RequiredArgsConstructor
public class boxController {

    private final boxService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<box>> crear(@RequestBody box entidad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Box registrado exitosamente", servicio.guardar(entidad)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<box>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Box encontrado", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<box>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de boxes y habitaciones", servicio.listarTodos()));
    }
}