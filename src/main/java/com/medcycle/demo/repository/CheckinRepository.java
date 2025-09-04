package com.medcycle.demo.repository;

import com.medcycle.demo.entity.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<Checkin, Long> {
}
