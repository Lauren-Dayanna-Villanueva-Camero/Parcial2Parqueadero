package com.usco.Parcial2Parqueadero.Repository;

import com.usco.Parcial2Parqueadero.model.Acomodador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AcomodadorRepository extends JpaRepository<Acomodador, Integer> {
    Optional<Acomodador> findByUsuarioId(Integer usuarioId);
}