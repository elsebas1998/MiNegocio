package com.jsca.Mi.negocio.controller;

import com.jsca.Mi.negocio.dto.DireccionRequestDto;
import com.jsca.Mi.negocio.dto.DireccionResponseDto;
import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import com.jsca.Mi.negocio.services.CoreServices;
import com.jsca.Mi.negocio.services.mapper.DireccionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    @Autowired
    private  CoreServices coreService;



    @PostMapping("/{clienteId}")
    public ResponseEntity<DireccionResponseDto> agregarDireccion(@PathVariable Long clienteId,
                                                                 @RequestBody DireccionRequestDto direccionRequestDto) {
        DireccionEntity direccion = DireccionMapper.toEntity(direccionRequestDto);
        DireccionEntity nuevaDireccion = coreService.agregarDireccion(clienteId, direccion);
        return ResponseEntity.ok(DireccionMapper.toDto(nuevaDireccion));
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<List<DireccionResponseDto>> listarDirecciones(@PathVariable Long clienteId) {
        List<DireccionEntity> direcciones = coreService.obtenerDireccionesCliente(clienteId);
        List<DireccionResponseDto> result = direcciones.stream()
                .map(DireccionMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}