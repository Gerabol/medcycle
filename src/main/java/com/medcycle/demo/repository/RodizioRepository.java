package com.medcycle.demo.repository;

import java.util.List;
import java.util.Optional;

import com.medcycle.demo.entity.Rodizio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RodizioRepository extends JpaRepository<Rodizio, Long> {

    @Query("SELECT r FROM Rodizio r JOIN FETCH r.localParceiro JOIN FETCH r.especialidade JOIN FETCH r.preceptor WHERE r.id = :id")
    Optional<Rodizio> findByIdComRelacoes(@Param("id") Long id);

    @Query("SELECT DISTINCT r FROM Rodizio r JOIN FETCH r.localParceiro JOIN FETCH r.especialidade JOIN FETCH r.preceptor")
    List<Rodizio> findAllComRelacoes();
}
