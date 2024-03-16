package com.slb.dev.repository;

import com.slb.dev.model.Prix;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PrixRepository extends JpaRepository<Prix, Long> {
}
