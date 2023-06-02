package com.sanvalero.gym.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "horario")
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
    @NotBlank(message = "El campo no puede estar vacio")
    private boolean asistencia;
    @Column
    private double latitude;
    @Column
    private double longitude;
    @Column
    private String local;

}
