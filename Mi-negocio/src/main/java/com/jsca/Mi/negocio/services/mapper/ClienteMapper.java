package com.jsca.Mi.negocio.services.mapper;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.dto.ClienteResponseDto;
import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;

import java.util.List;

public class ClienteMapper {
    public static ClienteEntity toEntity(ClienteRequestDto dto, final List<DireccionEntity> direccion) {
        ClienteEntity cliente = new ClienteEntity();
        cliente.setTipoIdentificacion(dto.getTipoIdentificacion());
        cliente.setNumeroIdentificacion(dto.getNumeroIdentificacion());
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setCorreo(dto.getCorreo());
        cliente.setCelular(dto.getCelular());
        cliente.setDirecciones(direccion);
        return cliente;
    }

    public static ClienteResponseDto toDto(ClienteEntity cliente) {
        ClienteResponseDto dto = new ClienteResponseDto();
        dto.setId(cliente.getCodCliente());
        dto.setTipoIdentificacion(cliente.getTipoIdentificacion());
        dto.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setCorreo(cliente.getCorreo());
        dto.setCelular(cliente.getCelular());
        return dto;
    }
}
