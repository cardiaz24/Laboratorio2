package com.example.laboratorio2.controller;

import com.example.laboratorio2.model.Mascota;

import com.example.laboratorio2.service.MascotaService;
import com.example.laboratorio2.service.PersonaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;
    private final PersonaService personaService;

    public MascotaController(MascotaService mascotaService, PersonaService personaService) {
        this.mascotaService = mascotaService;
        this.personaService = personaService;
    }

    @GetMapping("/nueva/{personaId}")
    public String mostrarFormularioNuevaMascota(@PathVariable Long personaId, Model model) {
        Mascota mascota = new Mascota();
        mascota.setPersona(personaService.obtenerPorId(personaId));
        model.addAttribute("mascota", mascota);
        return "crear_mascota";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota mascota) {
        mascotaService.guardarMascota(mascota);
        return "redirect:/personas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/personas";
    }

}
