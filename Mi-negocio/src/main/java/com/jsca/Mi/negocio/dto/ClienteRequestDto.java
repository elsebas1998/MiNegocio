package com.jsca.Mi.negocio.dto;

import lombok.Data;

@Data
public class ClienteRequestDto {
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private DireccionRequestDto direccionRequestDto;

    public ClienteRequestDto(String tipoIdentificacion, String numeroIdentificacion, String nombre, String apellido, String correo, String celular, DireccionRequestDto direccionRequestDto) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.direccionRequestDto = direccionRequestDto;
    }

    public ClienteRequestDto() {
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public DireccionRequestDto getDireccionRequestDto() {
        return direccionRequestDto;
    }

    public void setDireccionRequestDto(DireccionRequestDto direccionRequestDto) {
        this.direccionRequestDto = direccionRequestDto;
    }
}
