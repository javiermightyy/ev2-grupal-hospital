package com.hospital.demo.controller;

import com.hospital.demo.dto.request.medicamentoRequestDTO;
import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.medicamento;
import com.hospital.demo.service.medicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/medicamentos")
@RequiredArgsConstructor
public class medicamentoController {

    private final medicamentoService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<medicamento>> crear(@RequestBody medicamentoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Medicamento registrado exitosamente", servicio.guardar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<medicamento>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Medicamento encontrado", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<medicamento>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de medicamentos", servicio.listarTodos()));
    }
}