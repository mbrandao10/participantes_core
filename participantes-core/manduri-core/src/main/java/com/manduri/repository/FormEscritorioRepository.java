package com.manduri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manduri.model.FormEscritorio;

@Repository
public interface FormEscritorioRepository extends JpaRepository<FormEscritorio, Long> {
    
}
