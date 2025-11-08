package com.usco.Parcial2Parqueadero.Repository;

import com.usco.Parcial2Parqueadero.model.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculo, Integer> {
    Optional<TipoVehiculo> findByNombreTipo(String nombreTipo);
}