package com.usco.Parcial2Parqueadero.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String nombre;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}