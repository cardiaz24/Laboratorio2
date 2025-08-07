package com.example.laboratorio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.laboratorio2.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
}
