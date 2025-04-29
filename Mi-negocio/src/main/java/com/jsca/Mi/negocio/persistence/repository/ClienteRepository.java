package com.jsca.Mi.negocio.persistence.repository;

import com.jsca.Mi.negocio.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByNumeroIdentificacion(String numeroIdentificacion);

    Optional<ClienteEntity> findByCorreo(String correo);

    Optional<ClienteEntity> findByCelular(String celular);

    void deleteByCodCliente(Integer codCliente);



}
