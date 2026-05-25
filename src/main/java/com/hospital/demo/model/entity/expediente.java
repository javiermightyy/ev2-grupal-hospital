package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "expedientes_clinicos")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class expediente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExpediente;
    private String tipoSangre;
    private String alergias;
    private String enfermedadesCronicas;

    @OneToOne 
    @JoinColumn(name = "id_paciente")
    private paciente paciente;
}