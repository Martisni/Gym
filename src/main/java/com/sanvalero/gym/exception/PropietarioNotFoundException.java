package com.sanvalero.gym.exception;

public class PropietarioNotFoundException extends Exception {

    public PropietarioNotFoundException() {super("Propietario not found");}

    public PropietarioNotFoundException(String message) {super(message);}

}
