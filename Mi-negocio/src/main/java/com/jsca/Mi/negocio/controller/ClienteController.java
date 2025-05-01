package com.jsca.Mi.negocio.controller;

import com.jsca.Mi.negocio.dto.ClienteRequestDto;
import com.jsca.Mi.negocio.dto.ClienteResponseDto;
import com.jsca.Mi.negocio.services.CoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteController {

    @Autowired
    private  CoreServices coreService;

    @PostMapping("/crear")
    public ResponseEntity crearCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
       return coreService.crearClienteConDireccionMatriz(clienteRequestDto);
    }

    @GetMapping("/{identificacion}")
    public ClienteResponseDto buscarClientes(@PathVariable String identificacion) throws Exception {
        return coreService.buscarCliente(identificacion);
    }

    @PostMapping("/actualizar")
    public ResponseEntity actualizarCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        return coreService.actualizarCliente(clienteRequestDto);
    }

    @DeleteMapping("/{identificacion}")
    public ResponseEntity eliminarCliente(@PathVariable String identificacion) throws Exception {
        return  coreService.eliminarCliente(identificacion);
    }
}
