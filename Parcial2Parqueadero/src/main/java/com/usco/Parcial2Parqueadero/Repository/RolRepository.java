package com.usco.Parcial2Parqueadero.Repository;

import com.usco.Parcial2Parqueadero.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNombre(String nombre);
}