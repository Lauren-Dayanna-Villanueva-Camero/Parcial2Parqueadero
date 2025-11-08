package com.usco.Parcial2Parqueadero.Services;

import com.usco.Parcial2Parqueadero.model.Rol;
import com.usco.Parcial2Parqueadero.Repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    public Rol buscarPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}