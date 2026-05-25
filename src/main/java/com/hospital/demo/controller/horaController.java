package com.hospital.demo.controller;

import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.hora;
import com.hospital.demo.service.horaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/horas")
@RequiredArgsConstructor
public class horaController {

    private final horaService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<hora>> crear(@RequestBody hora entidad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Hora médica creada exitosamente", servicio.guardar(entidad)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<hora>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Hora médica encontrada", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<hora>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de horas médicas", servicio.listarTodos()));
    }
}