package com.hospital.demo.dto.request;

import lombok.Data;

@Data
public class medicamentoRequestDTO {
    // ¡OJO! Revisa tu entidad 'medicamento.java' y asegúrate de que estos nombres coincidan.
    // Solo omitimos el ID.
    private String nombre;
    private String principioActivo;
    private Integer stockDisponible;
}