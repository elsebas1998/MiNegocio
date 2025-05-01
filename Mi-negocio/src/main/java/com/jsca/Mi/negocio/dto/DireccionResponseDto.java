package com.jsca.Mi.negocio.dto;

import lombok.Data;

@Data
public class DireccionResponseDto {
    private Integer id;
    private String provincia;
    private String ciudad;
    private String direccion;
    private Boolean esMatriz;

    public DireccionResponseDto(Integer id, String provincia, String ciudad, String direccion, Boolean esMatriz) {
        this.id = id;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.esMatriz = esMatriz;
    }

    public DireccionResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEsMatriz() {
        return esMatriz;
    }

    public void setEsMatriz(Boolean esMatriz) {
        this.esMatriz = esMatriz;
    }
}
