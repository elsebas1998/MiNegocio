package com.jsca.Mi.negocio.services.impl;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.dto.ClienteResponseDto;
import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.dto.DireccionResponseDto;
import com.jsca.Mi.negocio.exception.MiNegocioException;
import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import com.jsca.Mi.negocio.persistence.service.ClienteServices;
import com.jsca.Mi.negocio.persistence.service.DireccionService;
import com.jsca.Mi.negocio.services.CoreServices;
import com.jsca.Mi.negocio.services.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoreServicesImpl implements CoreServices {
    @Autowired
    private ClienteServices clienteService;

    @Autowired
    private DireccionService direccionService;

    @Override
    public ResponseEntity crearClienteConDireccionMatriz(final ClienteRequestDto cliente) {

        verificacionDatosCliente(cliente.getNumeroIdentificacion(), cliente.getCelular(), cliente.getCorreo());
        DireccionEntity direccion = validarDireccion(cliente.getDireccionRequestDto());
        List<DireccionEntity> listaMatriz = new ArrayList<DireccionEntity>();
        listaMatriz.add(direccion);
        ClienteEntity clienteGuardado = ClienteMapper.toEntity(cliente, listaMatriz);
        clienteService.save(clienteGuardado);
        return ResponseEntity.ok().build();
    }

    private DireccionEntity validarDireccion(final DireccionRequestDto direccionRequestDto){
        DireccionEntity direccionMatriz = new DireccionEntity();
        direccionMatriz.setProvincia(direccionRequestDto.getProvincia());
        direccionMatriz.setCiudad(direccionRequestDto.getCiudad());
        direccionMatriz.setDireccion(direccionRequestDto.getDireccion());
        direccionMatriz.setEsMatriz(true);
        return direccionMatriz;
    }

    private void verificacionDatosCliente(final String identificacion, final String numCelular, final String correo){
        try {
            Optional<ClienteEntity> clienteI = clienteService.findByNumeroIdentificacion(identificacion);
            Optional<ClienteEntity> clienteC = clienteService.findByCorreo(numCelular);
            Optional<ClienteEntity> clienteCe = clienteService.findByNumCelular(correo);

            if(clienteI.isPresent()) {
                throw new Exception("Ya existe un cliente con este documento ");
            }
            if(clienteC.isPresent()) {
                throw new Exception("Ya existe un cliente con este correo");
            }
            if(clienteCe.isPresent()) {
                throw new Exception("Ya existe un cliente con este numero de celular");
            }
        } catch (Exception e) {
            throw new MiNegocioException();
        }
    }

    @Override
    public ResponseEntity actualizarCliente(ClienteRequestDto clienteActualizado) {
        ClienteEntity clienteExistente = clienteService.findByNumeroIdentificacion(clienteActualizado.getNumeroIdentificacion())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setApellido(clienteActualizado.getApellido());
        clienteExistente.setCorreo(clienteActualizado.getCorreo());
        clienteExistente.setCelular(clienteActualizado.getCelular());
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity eliminarCliente(String identificacion) throws Exception {
        Optional<ClienteEntity> validarCliente = clienteService.findByNumeroIdentificacion(identificacion);
        if (validarCliente.isEmpty()) {
            throw new Exception("Cliente no encontrado");
        }
        clienteService.eliminarCliente(identificacion);
        return ResponseEntity.ok().build();
    }

    @Override
    public ClienteResponseDto buscarCliente(String identificacion) throws Exception {
     Optional<ClienteEntity> clienteBuscado = clienteService.findByNumeroIdentificacion(identificacion);
     if (clienteBuscado.isPresent()) {
         ClienteEntity clienteEntity = clienteBuscado.get();
         ClienteResponseDto cliente = new ClienteResponseDto();
         cliente.setApellido(clienteEntity.getApellido());
         cliente.setNombre(clienteEntity.getNombre());
         cliente.setCorreo(clienteEntity.getCorreo());
         cliente.setCelular(clienteEntity.getCelular());
         cliente.setNumeroIdentificacion(clienteEntity.getNumeroIdentificacion());
         cliente.setTipoIdentificacion(clienteEntity.getTipoIdentificacion());
         return cliente;
     } else {
         throw new Exception("Cliente no encontrado");
     }

    }

    @Override
    public ResponseEntity agregarDireccion(DireccionRequestDto direccion, String identificacion) throws Exception {
        Optional<ClienteEntity> clienteBuscado = clienteService.findByNumeroIdentificacion(identificacion);
        if (clienteBuscado.isEmpty()) {
            throw new Exception("No existe el cliente");
        } else {
            DireccionEntity direccionEntity = new DireccionEntity();
            direccionEntity.getCliente();
            direccionEntity.getEsMatriz();
            direccionEntity.getDireccion();
            direccionEntity.getCiudad();
            direccionEntity.getProvincia();
            direccionService.guardarDireccion(direccionEntity);
            return ResponseEntity.ok().build();
        }

    }

    @Override
    public List<DireccionResponseDto> obtenerDireccionesCliente(String identificacion) throws Exception {
        Optional<ClienteEntity> clienteBuscado = clienteService.findByNumeroIdentificacion(identificacion);
        if (clienteBuscado.isEmpty()) {
            throw new Exception("No existe el cliente");
        } else {
            List<DireccionEntity> direccionEntities = direccionService.obtenerDirecciones(clienteBuscado.get().getCodCliente());
            List<DireccionResponseDto> direccionResponseDtos = direccionEntities.stream()
                    .map(direccion -> new DireccionResponseDto(
                            direccion.getId(),
                            direccion.getProvincia(),
                            direccion.getCiudad(),
                            direccion.getDireccion(),
                            direccion.getEsMatriz()
                    ))
                    .toList();
            return direccionResponseDtos;
        }
    }
}
