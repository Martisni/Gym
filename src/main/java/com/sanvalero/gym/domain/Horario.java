package com.sanvalero.gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dia_entreno")
    @NotNull(message = "El campo es obligatorio")
    private LocalDate diaEntreno;
    @Column(name = "hora_entreno")
    @NotNull(message = "El campo es obligatorio")
    private LocalTime horaEntreno;
    @Column
    private boolean asistencia;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column(name = "franja_horaria")
    private String franjaHoraria;

}
