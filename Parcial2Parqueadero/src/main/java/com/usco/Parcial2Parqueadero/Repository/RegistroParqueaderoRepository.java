package com.usco.Parcial2Parqueadero.Repository;

import com.usco.Parcial2Parqueadero.model.RegistroParqueadero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroParqueaderoRepository extends JpaRepository<RegistroParqueadero, Integer> {
    List<RegistroParqueadero> findByTipoVehiculoId(Integer tipoVehiculoId);
}