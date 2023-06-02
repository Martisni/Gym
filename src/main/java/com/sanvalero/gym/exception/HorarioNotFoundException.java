package com.sanvalero.gym.exception;

public class HorarioNotFoundException extends Exception {

    public HorarioNotFoundException() {super("Horario not found");}

    public HorarioNotFoundException(String message) {super(message);}

}
