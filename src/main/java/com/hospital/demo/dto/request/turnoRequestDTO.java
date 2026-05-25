package com.hospital.demo.dto.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class turnoRequestDTO {
    // Igual que antes, omitimos el idTurno porque la base de datos lo genera solo
    private String rutEmpleado;
    private String area;
    private LocalDateTime inicioTurno;
    private LocalDateTime finTurno;
}