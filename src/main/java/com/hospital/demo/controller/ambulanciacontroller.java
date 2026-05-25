package com.hospital.demo.controller;

import com.hospital.demo.dto.request.ambulanciaRequestDTO;
import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.ambulancia;
import com.hospital.demo.service.ambulanciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ambulancias")
@RequiredArgsConstructor
public class ambulanciacontroller {

    private final ambulanciaService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<ambulancia>> crear(@RequestBody ambulanciaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Ambulancia registrada exitosamente", servicio.guardar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<ambulancia>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Ambulancia encontrada", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<ambulancia>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de ambulancias", servicio.listarTodos()));
    }
}