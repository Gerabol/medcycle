package com.medcycle.demo.repository;

import com.medcycle.demo.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}