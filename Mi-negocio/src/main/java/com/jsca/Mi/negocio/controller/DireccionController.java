package com.jsca.Mi.negocio.controller;

import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.dto.DireccionResponseDto;
import com.jsca.Mi.negocio.services.CoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/direcciones")
public class DireccionController {

    @Autowired
    private  CoreServices coreService;

    @PostMapping("/agregar/{clienteId}")
    public ResponseEntity agregarDireccion(@PathVariable String identificacion,
                                                                 @RequestBody DireccionRequestDto direccionRequestDto) throws Exception {
        return coreService.agregarDireccion(direccionRequestDto, identificacion);
    }

    @GetMapping("/{clienteId}")
    public List<DireccionResponseDto> listarDirecciones(@PathVariable String identificacion) throws Exception {
       return coreService.obtenerDireccionesCliente(identificacion);
    }
}