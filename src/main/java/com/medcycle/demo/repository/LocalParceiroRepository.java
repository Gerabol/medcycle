package com.medcycle.demo.repository;

import com.medcycle.demo.entity.LocalParceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalParceiroRepository extends JpaRepository<LocalParceiro, Long> {
}
