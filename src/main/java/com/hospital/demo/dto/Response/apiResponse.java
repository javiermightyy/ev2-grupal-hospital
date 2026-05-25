package com.hospital.demo.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class apiResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private T data;

    public static <T> apiResponse<T> success(String message, T data) {
        return new apiResponse<>(LocalDateTime.now(), 200, message, data);
    }
}