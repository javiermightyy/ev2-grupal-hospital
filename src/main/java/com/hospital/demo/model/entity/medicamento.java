package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicamentos")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class medicamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;
    private String nombre;
    private String principioActivo;
    private Integer stockDisponible;
    private LocalDate fechaVencimiento;
}