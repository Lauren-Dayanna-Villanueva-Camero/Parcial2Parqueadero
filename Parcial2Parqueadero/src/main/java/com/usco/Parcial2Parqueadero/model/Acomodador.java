package com.usco.Parcial2Parqueadero.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "acomodador")
@Data
public class Acomodador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_acomodador", nullable = false, length = 100)
    private String nombreAcomodador;

    @Column(length = 50)
    private String turno;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}