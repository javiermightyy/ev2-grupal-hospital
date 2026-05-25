package com.hospital.demo.dto.request;

import lombok.Data;

@Data
public class ambulanciaRequestDTO {
    private String patente;
    private String tipo;         
    private String estado;
    private String ubicacionActual; 
}