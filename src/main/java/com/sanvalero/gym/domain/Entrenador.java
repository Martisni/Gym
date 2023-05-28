package com.sanvalero.gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_entrenador")
    private String nombreEntrenador;
    @Column(name = "apellido_entrenador")
    private String apellidoEntrenador;
    @Column(name = "dni_entrenador")
    private String dniEntrenador;
    @Column(name = "fecha_contrato")
    private LocalDate fechaContrato;
    @Column
    private boolean especialidad;
    @Column
    private int edad;

}
