package com.hospital.demo.controller;

import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.expediente;
import com.hospital.demo.service.expedienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/expedientes")
@RequiredArgsConstructor
public class expedienteController {

    private final expedienteService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<expediente>> crear(@RequestBody expediente entidad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Expediente creado exitosamente", servicio.guardar(entidad)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<expediente>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Expediente encontrado", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<expediente>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de expedientes", servicio.listarTodos()));
    }
}