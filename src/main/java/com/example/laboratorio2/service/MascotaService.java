package com.example.laboratorio2.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.laboratorio2.model.Mascota;
import com.example.laboratorio2.model.Persona;
import com.example.laboratorio2.repository.MascotaRepository;
import com.example.laboratorio2.repository.PersonaRepository;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final PersonaRepository personaRepository;

    public MascotaService(MascotaRepository mascotaRepository, PersonaRepository personaRepository) {
        this.mascotaRepository = mascotaRepository;
        this.personaRepository = personaRepository;
    }

    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    public void guardarMascota(Mascota mascota) {
        Long personaId = mascota.getPersona().getId();
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        mascota.setPersona(persona); // asocia la mascota a una persona válida
        mascotaRepository.save(mascota);
    }

    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    public Mascota obtenerPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }
}
