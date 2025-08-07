package com.example.laboratorio2.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.laboratorio2.model.Direccion; 


public interface DireccionRepository extends JpaRepository<Direccion, Long> {
     List<Direccion> findByPersonaId(Long personaId);
}
