package com.jsca.Mi.negocio.services.impl;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.dto.DireccionRequestDto;
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
        ClienteEntity nuevoCliente = clienteService.save(clienteGuardado);
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
    public ClienteEntity actualizarCliente(Long id, ClienteEntity clienteActualizado) {
        ClienteEntity clienteExistente = clienteService.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombre(clienteActualizado.getNombre());
        clienteExistente.setApellido(clienteActualizado.getApellido());
        clienteExistente.setCorreo(clienteActualizado.getCorreo());
        clienteExistente.setCelular(clienteActualizado.getCelular());

        return clienteService.save(clienteExistente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteService.delete(id);
    }

    @Override
    public List<ClienteEntity> buscarClientes(String criterio) {
        return clienteService.findAll().stream()
                .filter(cliente -> cliente.getNumeroIdentificacion().contains(criterio) ||
                        cliente.getNombre().toLowerCase().contains(criterio.toLowerCase()))
                .toList();
    }

    @Override
    public DireccionEntity agregarDireccion(Long clienteId, DireccionEntity direccion) {
        ClienteEntity cliente = clienteService.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        direccion.setCliente(cliente);
        return direccionService.save(direccion);
    }

    @Override
    public List<DireccionEntity> obtenerDireccionesCliente(Long clienteId) {
        return direccionService.findByClienteId(clienteId);
    }
}
