package com.jsca.Mi.negocio.persistence.service.impl;

import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.repository.ClienteRepository;
import com.jsca.Mi.negocio.persistence.service.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicesImpl implements ClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<ClienteEntity> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public void eliminarCliente(String identificacion) {
        clienteRepository.deleteByNumeroIdentificacion(identificacion);
    }

    @Override
    public Optional<ClienteEntity> findByNumeroIdentificacion(String numeroIdentificacion) {
        return clienteRepository.findByNumeroIdentificacion(numeroIdentificacion);
    }

    @Override
    public Optional<ClienteEntity> findByCorreo(String correo) {
        return clienteRepository.findByCorreo(correo);
    }

    @Override
    public Optional<ClienteEntity> findByNumCelular(String numCelular) {
        return clienteRepository.findByCelular(numCelular);
    }
}