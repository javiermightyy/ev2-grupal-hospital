package com.hospital.demo.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class pacienteRequestDTO {
    // ¡Ojo! No ponemos el idPaciente aquí, porque la base de datos lo genera solo.
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