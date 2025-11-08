package com.usco.Parcial2Parqueadero.controller;

import com.usco.Parcial2Parqueadero.model.TipoVehiculo;
import com.usco.Parcial2Parqueadero.Services.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tipo-vehiculo")
public class TipoVehiculoController {

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tiposVehiculo", tipoVehiculoService.listarTodos());
        return "tipo-vehiculo/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tipoVehiculo", new TipoVehiculo());
        return "tipo-vehiculo/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("tipoVehiculo") TipoVehiculo tipoVehiculo) {
        tipoVehiculoService.guardar(tipoVehiculo);
        return "redirect:/tipo-vehiculo";
    }
}