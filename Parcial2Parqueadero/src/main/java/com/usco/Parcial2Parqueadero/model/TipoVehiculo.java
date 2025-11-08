package com.usco.Parcial2Parqueadero.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "tipo_vehiculo")
@Data
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_tipo", nullable = false, length = 50)
    private String nombreTipo;

    @Column(length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "tipoVehiculo")
    private List<RegistroParqueadero> registros;
}