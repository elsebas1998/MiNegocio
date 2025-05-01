package com.jsca.Mi.negocio.persistence.service.impl;

import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import com.jsca.Mi.negocio.persistence.repository.DireccionRepository;
import com.jsca.Mi.negocio.persistence.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public DireccionEntity guardarDireccion(DireccionEntity direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    public List<DireccionEntity> obtenerDirecciones(Integer clienteId) {
        return direccionRepository.findByClienteCodCliente(clienteId);
    }
}
