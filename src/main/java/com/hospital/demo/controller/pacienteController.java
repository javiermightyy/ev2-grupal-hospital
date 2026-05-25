package com.hospital.demo.controller;
import com.hospital.demo.dto.request.pacienteRequestDTO;
import com.hospital.demo.dto.Response.apiResponse;
import com.hospital.demo.model.entity.paciente;
import com.hospital.demo.service.pacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@RequiredArgsConstructor
public class pacienteController {

    private final pacienteService servicio;

    @PostMapping
    // 1. Cambiamos 'paciente entidad' por 'pacienteRequestDTO dto'
    public ResponseEntity<apiResponse<paciente>> crear(@RequestBody pacienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                // 2. Le pasamos el 'dto' al servicio en vez de la entidad
                .body(apiResponse.success("Paciente creado exitosamente", servicio.guardar(dto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<apiResponse<paciente>> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(apiResponse.success("Paciente encontrado", servicio.obtenerPorId(id)));
    }

    @GetMapping
    public ResponseEntity<apiResponse<List<paciente>>> listarTodos() {
        return ResponseEntity.ok(apiResponse.success("Lista de pacientes", servicio.listarTodos()));
    }
}