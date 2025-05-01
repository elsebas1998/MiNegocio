package com.jsca.Mi.negocio.persistence.service;

import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DireccionService {

    DireccionEntity guardarDireccion(DireccionEntity direccion);
    List<DireccionEntity> obtenerDirecciones(Integer clienteId);
}
