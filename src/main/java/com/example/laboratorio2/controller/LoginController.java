package com.example.laboratorio2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * Muestra la página de inicio de sesión.
     * 
     * @return el nombre de la vista de inicio de sesión.
     */
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @GetMapping("/default")
    public String redireccionPorRol(org.springframework.security.core.Authentication auth) {
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin_dashboard";
        } else {
            return "redirect:/user/home";
        }
    }

}
