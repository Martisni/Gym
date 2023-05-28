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
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_secretaria")
    private String nombreSecretaria;
    @Column(name = "apellido_secretaria")
    private String apellidoSecretaria;
    @Column(name = "dni_secretaria")
    private String dniSecretaria;
    @Column(name = "contrato_secretaria")
    private LocalDate fechaContSecre;
    @Column(name = "horas_contrato")
    private int horasContrato;


}
