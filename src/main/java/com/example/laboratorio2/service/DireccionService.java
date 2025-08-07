package com.example.laboratorio2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.laboratorio2.model.Direccion;
import com.example.laboratorio2.model.Persona;
import com.example.laboratorio2.repository.DireccionRepository;
import com.example.laboratorio2.repository.PersonaRepository;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;
    private final PersonaRepository personaRepository;

    public DireccionService(DireccionRepository direccionRepository, PersonaRepository personaRepository) {
        this.direccionRepository = direccionRepository;
        this.personaRepository = personaRepository;
    }

    public List<Direccion> listarDireccion() {
        return direccionRepository.findAll();
    }

       public List<Direccion> listarPorPersona(Long personaId) {
        return direccionRepository.findByPersonaId(personaId);
    }

    public void guardar(Long personaId, Direccion direccion) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        direccion.setPersona(persona);
        direccionRepository.save(direccion);
    }

    public Direccion obtenerPorId(Long id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Direccion no encontrada"));
    }

    public void actualizar(Long id, Direccion direccionActualizada) {
        Direccion direccion = obtenerPorId(id);
        direccion.setDireccion(direccionActualizada.getDireccion());
        direccionRepository.save(direccion);
    }

    public void eliminar(Long id) {
        direccionRepository.deleteById(id);
    }
}
