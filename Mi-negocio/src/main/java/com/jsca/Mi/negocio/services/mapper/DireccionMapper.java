package com.jsca.Mi.negocio.services.mapper;

import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.dto.DireccionResponseDto;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;

public class DireccionMapper {
    public static DireccionEntity toEntity(DireccionRequestDto dto) {
        DireccionEntity direccion = new DireccionEntity();
        direccion.setProvincia(dto.getProvincia());
        direccion.setCiudad(dto.getCiudad());
        direccion.setDireccion(dto.getDireccion());
        direccion.setEsMatriz(false);
        return direccion;
    }

    public static DireccionResponseDto toDto(DireccionEntity direccion) {
        DireccionResponseDto dto = new DireccionResponseDto();
        dto.setId(direccion.getId());
        dto.setProvincia(direccion.getProvincia());
        dto.setCiudad(direccion.getCiudad());
        dto.setDireccion(direccion.getDireccion());
        dto.setEsMatriz(direccion.getEsMatriz());
        return dto;
    }
}
