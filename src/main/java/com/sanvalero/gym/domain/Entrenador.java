package com.sanvalero.gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "El campo es obligatorio")
    private String dniEntrenador;
    @Column(name = "fecha_contrato")
    private LocalDate fechaContrato;
    @Column
    @NotNull(message = "El campo es obligatorio")
    private boolean especialidad;
    @Column
    @Min(value = 18)
    private int edad;

}
