package com.hospital.demo.controller;

import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.receta;
import com.hospital.demo.service.recetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recetas")
@RequiredArgsConstructor
public class recetaController {

    private final recetaService servicio;

    @PostMapping
    public ResponseEntity<apiResponse<receta>> crear(@RequestBody receta entidad) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(apiResponse.success("Receta emitida exitosamente", servicio.guardar(entidad)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<receta>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Receta encontrada", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<receta>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de recetas", servicio.listarTodos()));
    }
}