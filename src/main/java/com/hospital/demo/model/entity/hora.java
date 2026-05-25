package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "horas_medicas")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class hora {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHora;
    private LocalDateTime fechaHora;
    private String medico;
    private String especialidad;
    private String estado;
    
    @ManyToOne 
    @JoinColumn(name = "id_paciente")
    private paciente paciente;
}