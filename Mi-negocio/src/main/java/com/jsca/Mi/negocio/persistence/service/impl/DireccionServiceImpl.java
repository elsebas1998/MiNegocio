package com.jsca.Mi.negocio.persistence.service.impl;

import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import com.jsca.Mi.negocio.persistence.repository.DireccionRepository;
import com.jsca.Mi.negocio.persistence.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public DireccionEntity save(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public List<DireccionEntity> findByClienteId(Long clienteId) {
        return direccionRepository.findByClienteId(clienteId);
    }
}
