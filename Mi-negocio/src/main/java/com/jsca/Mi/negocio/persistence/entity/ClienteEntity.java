package com.jsca.Mi.negocio.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCliente;

    @Column(nullable = false)
    private String tipoIdentificacion;

    @Column(nullable = false, unique = true)
    private String numeroIdentificacion;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false, unique = true)
    private String celular;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DireccionEntity> direcciones;
}
