package com.usco.Parcial2Parqueadero.Services;

import com.usco.Parcial2Parqueadero.model.RegistroParqueadero;
import com.usco.Parcial2Parqueadero.Repository.RegistroParqueaderoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroParqueaderoService {

    private final RegistroParqueaderoRepository registroParqueaderoRepository;

    public List<RegistroParqueadero> listarTodos() {
        return registroParqueaderoRepository.findAll();
    }

    public List<RegistroParqueadero> listarPorTipoVehiculo(Integer tipoVehiculoId) {
        return registroParqueaderoRepository.findByTipoVehiculoId(tipoVehiculoId);
    }

    public RegistroParqueadero guardar(RegistroParqueadero registroParqueadero) {
        return registroParqueaderoRepository.save(registroParqueadero);
    }

    public void eliminar(RegistroParqueadero registroParqueadero) {
        registroParqueaderoRepository.delete(registroParqueadero);
    }

    public RegistroParqueadero buscarPorId(Integer id) {
        return registroParqueaderoRepository.findById(id).orElse(null);
    }

    public void actualizarUbicacion(Integer id, String ubicacion) {
        RegistroParqueadero registro = buscarPorId(id);
        if (registro != null) {
            registro.setUbicacion(ubicacion);
            registroParqueaderoRepository.save(registro);
        }
    }

    public void registrarSalida(Integer id, LocalDateTime horaSalida) {
        RegistroParqueadero registro = buscarPorId(id);
        if (registro != null) {
            registro.setHoraSalida(horaSalida);
            registroParqueaderoRepository.save(registro);
        }
    }
}