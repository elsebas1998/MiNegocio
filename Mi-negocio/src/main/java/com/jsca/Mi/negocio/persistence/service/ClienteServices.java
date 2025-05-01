package com.jsca.Mi.negocio.persistence.service;

import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;

import java.util.List;
import java.util.Optional;

public interface ClienteServices {
    ClienteEntity save(ClienteEntity cliente);
    Optional<ClienteEntity> findById(Long id);
    List<ClienteEntity> findAll();
    void eliminarCliente(String identificacion);
    Optional<ClienteEntity> findByNumeroIdentificacion(String numeroIdentificacion);

    Optional<ClienteEntity> findByCorreo(String correo);

    Optional<ClienteEntity> findByNumCelular(String numCelular);
}
