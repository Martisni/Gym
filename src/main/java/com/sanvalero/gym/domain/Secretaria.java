package com.sanvalero.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Secretaria {

    private long id;
    private String nombreSecretaria;
    private String apellidoSecretaria;
    private String dniSecretaria;
    private LocalDate fechaContSecre;
    private int horasContrato;


}
