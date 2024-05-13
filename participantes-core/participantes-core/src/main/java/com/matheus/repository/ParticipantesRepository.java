package com.matheus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.model.Participantes;

@Repository
public interface ParticipantesRepository extends JpaRepository<Participantes, Long> {
    
}
