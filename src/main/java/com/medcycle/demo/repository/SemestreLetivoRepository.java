package com.medcycle.demo.repository;
import java.lang.Long;

import com.medcycle.demo.entity.SemestreLetivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreLetivoRepository extends JpaRepository<SemestreLetivo, Long> {}
