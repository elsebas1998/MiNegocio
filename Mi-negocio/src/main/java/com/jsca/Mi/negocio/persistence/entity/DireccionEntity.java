package com.jsca.Mi.negocio.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "direccion")
@Data
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String provincia;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private Boolean esMatriz = false;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;
}
