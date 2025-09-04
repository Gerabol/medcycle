package com.medcycle.demo.repository;

import com.medcycle.demo.entity.RodizioAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RodizioAlunoRepository extends JpaRepository<RodizioAluno, Long> {

    @Query("SELECT ra FROM RodizioAluno ra JOIN FETCH ra.rodizio JOIN FETCH ra.aluno WHERE ra.id = :id")
    Optional<RodizioAluno> findByIdComRelacoes(@Param("id") Long id);
}