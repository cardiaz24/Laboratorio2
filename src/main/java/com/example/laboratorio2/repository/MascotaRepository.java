package com.example.laboratorio2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.laboratorio2.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
