package com.example.laboratorio2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador para manejar las peticiones relacionadas con el administrador.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
        @GetMapping("/dashboard")
    public String mostrarDashboardAdmin() {
        return "admin_dashboard";
    }
}
