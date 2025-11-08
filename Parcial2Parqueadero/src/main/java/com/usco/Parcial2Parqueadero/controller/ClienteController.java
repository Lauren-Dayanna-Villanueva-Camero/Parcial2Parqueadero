package com.usco.Parcial2Parqueadero.controller;

import com.usco.Parcial2Parqueadero.model.Cliente;
import com.usco.Parcial2Parqueadero.Services.ClienteService;
import com.usco.Parcial2Parqueadero.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "cliente/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/cliente";
    }
}