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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column
    private String dni;
    @Column
    private String correo;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column
    private boolean lesionado;
    @Column(name = "cuenta_bancaria")
    private float cuentaBancaria;

}
