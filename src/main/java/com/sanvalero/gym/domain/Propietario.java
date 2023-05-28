package com.sanvalero.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Propietario {

    private String nombrePropietario;
    private String apellidoPropietario;
    private String nif;
    private int numeroEmpleados;
    private  int numeroEstablecimiento;
    private LocalDate fechaPagos;

}
