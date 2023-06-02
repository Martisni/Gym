package com.sanvalero.gym.exception;

public class EntrenadorNotFoundException extends Exception {

    public EntrenadorNotFoundException() {super("Entrenador not found");}

    public EntrenadorNotFoundException(String message) {super(message);}

}
