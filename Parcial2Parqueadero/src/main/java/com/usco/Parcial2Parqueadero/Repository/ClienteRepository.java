package com.usco.Parcial2Parqueadero.Repository;

import com.usco.Parcial2Parqueadero.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByUsuarioUsername(String username);
}