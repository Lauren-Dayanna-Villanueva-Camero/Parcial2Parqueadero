package com.usco.Parcial2Parqueadero.Services;

import com.usco.Parcial2Parqueadero.model.Acomodador;
import com.usco.Parcial2Parqueadero.Repository.AcomodadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AcomodadorService {

    private final AcomodadorRepository acomodadorRepository;

    public List<Acomodador> listarTodos() {
        return acomodadorRepository.findAll();
    }

    public Acomodador buscarPorId(Integer id) {
        return acomodadorRepository.findById(id).orElse(null);
    }

    public Acomodador buscarPorUsuarioId(Integer usuarioId) {
        return acomodadorRepository.findByUsuarioId(usuarioId).orElse(null);
    }

    public void guardar(Acomodador acomodador) {
        acomodadorRepository.save(acomodador);
    }
}