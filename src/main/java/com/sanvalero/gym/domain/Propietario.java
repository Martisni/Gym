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
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_propietario")
    private String nombrePropietario;
    @Column
    private String nif;
    @Column(name = "numero_empleados")
    private int numeroEmpleados;
    @Column(name = "numero_locales")
    private  int numeroEstablecimiento;
    @Column(name = "fecha_pagos")
    private LocalDate fechaPagos;

}
