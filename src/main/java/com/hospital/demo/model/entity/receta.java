package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "recetas")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class receta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;
    private String indicaciones;
    private LocalDate fechaEmision;

    @ManyToOne 
    @JoinColumn(name = "id_paciente")
    private paciente paciente;

    @ManyToOne 
    @JoinColumn(name = "id_medicamento")
    private medicamento medicamento;
}