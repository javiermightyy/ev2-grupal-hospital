
package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "boxes")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class box {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBox;
    private String numeroSector;
    private String tipo;
    private String estado;
}