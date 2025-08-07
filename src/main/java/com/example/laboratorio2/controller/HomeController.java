package com.example.laboratorio2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String mostrarInicio() {
        return "redirect:/login"; // Redirige a la página de inicio de sesión
    }       
}
