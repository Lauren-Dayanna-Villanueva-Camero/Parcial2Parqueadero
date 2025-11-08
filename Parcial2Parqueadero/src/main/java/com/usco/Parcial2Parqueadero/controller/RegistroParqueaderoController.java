package com.usco.Parcial2Parqueadero.controller;

import com.usco.Parcial2Parqueadero.model.RegistroParqueadero;
import com.usco.Parcial2Parqueadero.model.TipoVehiculo;
import com.usco.Parcial2Parqueadero.model.Usuario;
import com.usco.Parcial2Parqueadero.Repository.UsuarioRepository;
import com.usco.Parcial2Parqueadero.Services.RegistroParqueaderoService;
import com.usco.Parcial2Parqueadero.Services.TipoVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/registro")
public class RegistroParqueaderoController {

    @Autowired
    private RegistroParqueaderoService registroParqueaderoService;

    @Autowired
    private TipoVehiculoService tipoVehiculoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String lista(Model model, Authentication auth) {
        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        if (usuario != null) {
            String rol = usuario.getRol().getNombre();
            model.addAttribute("rol", rol);

            if (rol.equals("CLIENTE")) {
                // Los clientes solo ven sus propios registros (basado en placa)
                // Aquí podrías implementar lógica específica si los clientes están asociados a placas
                model.addAttribute("registros", registroParqueaderoService.listarTodos());
            } else {
                model.addAttribute("registros", registroParqueaderoService.listarTodos());
            }
        }

        return "registro/lista";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model, Authentication auth) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);

        if (registro == null) {
            return "redirect:/registro";
        }

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
        model.addAttribute("registro", registro);
        model.addAttribute("rol", usuario != null ? usuario.getRol().getNombre() : "");

        return "registro/detalle";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        List<TipoVehiculo> tiposVehiculo = tipoVehiculoService.listarTodos();
        model.addAttribute("registro", new RegistroParqueadero());
        model.addAttribute("tiposVehiculo", tiposVehiculo);
        return "registro/form";
    }

    @PostMapping
    public String guardar(@ModelAttribute("registro") RegistroParqueadero registro) {
        registro.setHoraEntrada(LocalDateTime.now());
        registroParqueaderoService.guardar(registro);
        return "redirect:/registro";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);

        if (registro == null) {
            return "redirect:/registro";
        }

        List<TipoVehiculo> tiposVehiculo = tipoVehiculoService.listarTodos();
        model.addAttribute("registro", registro);
        model.addAttribute("tiposVehiculo", tiposVehiculo);
        return "registro/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);

        if (registro != null) {
            registroParqueaderoService.eliminar(registro);
        }

        return "redirect:/registro";
    }

    @GetMapping("/actualizar-ubicacion/{id}")
    public String mostrarFormularioUbicacion(@PathVariable Integer id, Model model, Authentication auth) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);

        if (registro == null) {
            return "redirect:/registro";
        }

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        // Solo ACOMODADOR puede actualizar ubicaciones
        if (usuario == null || !usuario.getRol().getNombre().equals("ACOMODADOR")) {
            return "redirect:/acceso-denegado";
        }

        model.addAttribute("registro", registro);
        return "registro/form-ubicacion";
    }

    @PostMapping("/actualizar-ubicacion")
    public String actualizarUbicacion(@RequestParam("id") Integer id,
                                      @RequestParam("ubicacion") String ubicacion,
                                      Authentication auth) {

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        // Solo ACOMODADOR puede actualizar ubicaciones
        if (usuario == null || !usuario.getRol().getNombre().equals("ACOMODADOR")) {
            return "redirect:/acceso-denegado";
        }

        registroParqueaderoService.actualizarUbicacion(id, ubicacion);
        return "redirect:/registro";
    }

    @GetMapping("/registrar-salida/{id}")
    public String mostrarFormularioSalida(@PathVariable Integer id, Model model, Authentication auth) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);

        if (registro == null) {
            return "redirect:/registro";
        }

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        // Solo ADMINISTRADOR y ACOMODADOR pueden registrar salidas
        if (usuario == null || 
            (!usuario.getRol().getNombre().equals("ADMINISTRADOR") && 
             !usuario.getRol().getNombre().equals("ACOMODADOR"))) {
            return "redirect:/acceso-denegado";
        }

        model.addAttribute("registro", registro);
        return "registro/form-salida";
    }

    @PostMapping("/registrar-salida")
    public String registrarSalida(@RequestParam("id") Integer id,
                                  @RequestParam("horaSalida") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime horaSalida,
                                  Authentication auth) {

        String email = auth.getName();
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        // Solo ADMINISTRADOR y ACOMODADOR pueden registrar salidas
        if (usuario == null || 
            (!usuario.getRol().getNombre().equals("ADMINISTRADOR") && 
             !usuario.getRol().getNombre().equals("ACOMODADOR"))) {
            return "redirect:/acceso-denegado";
        }

        registroParqueaderoService.registrarSalida(id, horaSalida);
        return "redirect:/registro";
    }
}