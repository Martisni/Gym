package com.sanvalero.gym.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "rutina")
public class Rutina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotNull(message = "El campo es obligatorio")
    private String modalidad;
    @Column
    private boolean material;
    @Column(name = "numero_series")
    @NotNull(message = "El campo es obligatorio")
    private int numeroSeries;
    @Column(name = "numero_repes")
    @NotNull(message = "El campo es obligatorio")
    private int numeroRepeticiones;
    @Column(name = "dias_entreno")
    @NotNull(message = "El campo es obligatorio")
    private int diasEntrenados;
    @Column
    @Max(value = 60)
    private int duracion;

}
