package com.sanvalero.gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String modalidad;
    @Column
    private boolean material;
    @Column(name = "numero_series")
    private int numeroSeries;
    @Column(name = "numero_repes")
    private int numeroRepeticiones;
    @Column(name = "dias_entreno")
    private int diasEntrenados;
    @Column
    private int duracion;

}
