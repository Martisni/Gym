package com.sanvalero.gym.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "secretaria")
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
    @Min(value = 40)
    private int horasContrato;


}
