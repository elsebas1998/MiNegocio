package com.jsca.Mi.negocio.services;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.dto.ClienteResponseDto;
import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.dto.DireccionResponseDto;
import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoreServices {
    ResponseEntity crearClienteConDireccionMatriz(final ClienteRequestDto cliente);
    ResponseEntity actualizarCliente(ClienteRequestDto clienteActualizado);
    ResponseEntity  eliminarCliente(String identificacion) throws Exception;
    ClienteResponseDto buscarCliente(String identificacion) throws Exception;
    ResponseEntity agregarDireccion(DireccionRequestDto direccion, String identificacion) throws Exception;
    List<DireccionResponseDto> obtenerDireccionesCliente(String identificacion) throws Exception;
}
