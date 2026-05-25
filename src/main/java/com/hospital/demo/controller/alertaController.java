package com.hospital.demo.controller;

import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.alerta;
import com.hospital.demo.service.alertaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alertas")
@RequiredArgsConstructor
public class alertaController {

    private final alertaService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<alerta>> crear(@RequestBody alerta entidad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Alerta generada exitosamente", servicio.guardar(entidad)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<alerta>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Alerta encontrada", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<alerta>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Historial de alertas", servicio.listarTodos()));
    }
}