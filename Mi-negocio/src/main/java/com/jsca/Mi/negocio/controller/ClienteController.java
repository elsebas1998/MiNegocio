package com.jsca.Mi.negocio.controller;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.dto.ClienteResponseDto;
import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import com.jsca.Mi.negocio.services.CoreServices;
import com.jsca.Mi.negocio.services.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private  CoreServices coreService;

    @PostMapping("/crear")
    public ResponseEntity crearCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
       return coreService.crearClienteConDireccionMatriz(clienteRequestDto);
    }

    @GetMapping("/{criterio}")
    public ResponseEntity<List<ClienteResponseDto>> buscarClientes(@PathVariable String criterio) {
        List<ClienteEntity> clientes = coreService.buscarClientes(criterio);
        List<ClienteResponseDto> result = clientes.stream()
                .map(ClienteMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> actualizarCliente(@PathVariable Long id,
                                                                @RequestBody ClienteRequestDto clienteRequestDto) {
        ClienteEntity cliente = ClienteMapper.toEntity(clienteRequestDto);
        ClienteEntity actualizado = coreService.actualizarCliente(id, cliente);
        return ResponseEntity.ok(ClienteMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        coreService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
