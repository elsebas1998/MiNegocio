package com.jsca.Mi.negocio.dto;

import lombok.Data;

@Data
public class ClienteResponseDto {
    private Integer id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
}
