package com.jsca.Mi.negocio.services;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoreServices {
    ResponseEntity crearClienteConDireccionMatriz(final ClienteRequestDto cliente)
    ClienteEntity actualizarCliente(Long id, ClienteEntity clienteActualizado);
    void eliminarCliente(Long id);
    List<ClienteEntity> buscarClientes(String criterio);
    DireccionEntity agregarDireccion(Long clienteId, DireccionEntity direccion);
    List<DireccionEntity> obtenerDireccionesCliente(Long clienteId);
}
