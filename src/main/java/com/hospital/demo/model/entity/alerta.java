package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class alerta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerta;
    private String tipo;
    private String mensaje;
    private LocalDateTime fechaHora;
    private String estado;
}