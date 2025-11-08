package com.usco.Parcial2Parqueadero.Services;

import com.usco.Parcial2Parqueadero.model.TipoVehiculo;
import com.usco.Parcial2Parqueadero.Repository.TipoVehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoVehiculoService {

    private final TipoVehiculoRepository tipoVehiculoRepository;

    public List<TipoVehiculo> listarTodos() {
        return tipoVehiculoRepository.findAll();
    }

    public TipoVehiculo buscarPorId(Integer id) {
        return tipoVehiculoRepository.findById(id).orElse(null);
    }

    public TipoVehiculo buscarPorNombre(String nombreTipo) {
        return tipoVehiculoRepository.findByNombreTipo(nombreTipo).orElse(null);
    }

    public void guardar(TipoVehiculo tipoVehiculo) {
        tipoVehiculoRepository.save(tipoVehiculo);
    }
}