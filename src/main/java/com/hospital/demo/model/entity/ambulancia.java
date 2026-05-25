package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ambulancias")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ambulancia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmbulancia;
    private String patente;
    private String tipo;
    private String estado;
    private String ubicacionActual;
}   