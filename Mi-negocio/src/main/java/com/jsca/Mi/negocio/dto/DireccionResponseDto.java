package com.jsca.Mi.negocio.dto;

import lombok.Data;

@Data
public class DireccionResponseDto {
    private Integer id;
    private String provincia;
    private String ciudad;
    private String direccion;
    private Boolean esMatriz;
}
