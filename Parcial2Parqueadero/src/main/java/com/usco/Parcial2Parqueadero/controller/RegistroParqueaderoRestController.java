package com.usco.Parcial2Parqueadero.controller;

import com.usco.Parcial2Parqueadero.model.RegistroParqueadero;
import com.usco.Parcial2Parqueadero.Services.RegistroParqueaderoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros")
@Tag(name = "Gestión de Registros de Parqueadero", description = "API REST para la gestión de entradas y salidas del parqueadero")
public class RegistroParqueaderoRestController {

    @Autowired
    private RegistroParqueaderoService registroParqueaderoService;

    @GetMapping
    @Operation(
            summary = "Listar todos los registros",
            description = "Retorna la lista completa de registros de parqueadero. Accesible para ADMINISTRADOR, ACOMODADOR y CLIENTE."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado")
    })
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'ACOMODADOR', 'CLIENTE')")
    public ResponseEntity<List<RegistroParqueadero>> listarTodos() {
        return ResponseEntity.ok(registroParqueaderoService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener registro por ID",
            description = "Retorna los detalles de un registro específico por su ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro encontrado"),
            @ApiResponse(responseCode = "404", description = "Registro no encontrado"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado")
    })
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'ACOMODADOR', 'CLIENTE')")
    public ResponseEntity<RegistroParqueadero> obtenerPorId(@PathVariable Integer id) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);
        return registro != null ? ResponseEntity.ok(registro) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(
            summary = "Crear nuevo registro",
            description = "Crea un nuevo registro de entrada al parqueadero. Solo accesible para usuarios con rol ADMINISTRADOR."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro creado exitosamente"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado - Solo ADMINISTRADOR")
    })
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<RegistroParqueadero> crear(@RequestBody RegistroParqueadero registro) {
        return ResponseEntity.ok(registroParqueaderoService.guardar(registro));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar registro",
            description = "Actualiza un registro existente. Solo accesible para usuarios con rol ADMINISTRADOR."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Registro no encontrada"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado - Solo ADMINISTRADOR")
    })
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<RegistroParqueadero> actualizar(@PathVariable Integer id, @RequestBody RegistroParqueadero registro) {
        RegistroParqueadero existente = registroParqueaderoService.buscarPorId(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        registro.setId(id);
        return ResponseEntity.ok(registroParqueaderoService.guardar(registro));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar registro",
            description = "Elimina un registro del sistema. Solo accesible para usuarios con rol ADMINISTRADOR."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registro eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Registro no encontrado"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado - Solo ADMINISTRADOR")
    })
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        RegistroParqueadero registro = registroParqueaderoService.buscarPorId(id);
        if (registro != null) {
            registroParqueaderoService.eliminar(registro);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}