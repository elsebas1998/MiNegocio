package com.jsca.Mi.negocio.persistence.repository;

import com.jsca.Mi.negocio.persistence.entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Long> {

    List<DireccionEntity> findByClienteCodCliente(Integer clienteId);

}
