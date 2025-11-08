package com.usco.Parcial2Parqueadero.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        System.out.println("LoginController - método login() ejecutado");
        return "login";
    }

    @GetMapping("/home")
    public String home(Authentication authentication) {
        return "redirect:/registro";
    }

    @GetMapping("/acceso-denegado")
    public String accesoDenegado(Model model) {
        model.addAttribute("mensaje", "No tienes permisos para acceder a esta página");
        return "acceso-denegado";
    }
}