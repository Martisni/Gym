package com.sanvalero.gym.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "dni_usuario")
    @NotNull(message = "El campo es obligatorio")
    private String dniUsuario;
    @Column
    @NotNull(message = "El campo es obligatorio")
    private String correo;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column
    @NotBlank(message = "El campo no puede estar vacio")
    private boolean lesionado;
    @Column(name = "cuenta_bancaria")
    private float cuentaBancaria;

}
