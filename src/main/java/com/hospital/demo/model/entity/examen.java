package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "examenes")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class examen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;
    private String tipoExamen;
    private LocalDate fecha;
    private String resultado;
    private String estado;
    
    @ManyToOne 
    @JoinColumn(name = "id_paciente")
    private paciente paciente;
}