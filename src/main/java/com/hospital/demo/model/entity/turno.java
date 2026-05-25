package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "turnos")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class turno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurno;
    private String rutEmpleado;
    private String area;
    private LocalDateTime inicioTurno;
    private LocalDateTime finTurno;
}