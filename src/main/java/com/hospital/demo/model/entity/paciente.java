package com.hospital.demo.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class paciente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;
    private Integer rut;
    private String dv;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;
}