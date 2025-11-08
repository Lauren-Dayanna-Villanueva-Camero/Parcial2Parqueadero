package com.usco.Parcial2Parqueadero.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_parqueadero")
@Data
public class RegistroParqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "placa_vehiculo", nullable = false, length = 6)
    private String placaVehiculo;

    @Column(name = "hora_entrada", nullable = false)
    private LocalDateTime horaEntrada;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(nullable = false, length = 20)
    private String ubicacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_vehiculo_id", nullable = false)
    @ToString.Exclude
    private TipoVehiculo tipoVehiculo;
}