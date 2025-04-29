package com.jsca.Mi.negocio.persistence.service;

import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;

import java.util.List;

public interface DireccionService {

    DireccionEntity save(DireccionEntity direccion);
    List<DireccionEntity> findByClienteId(Long clienteId);
}
