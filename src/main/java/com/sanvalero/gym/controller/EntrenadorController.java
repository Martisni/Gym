package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.exception.EntrenadorNotFoundException;
import com.sanvalero.gym.exception.ErrorMessage;
import com.sanvalero.gym.service.EntrenadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/gym/entrenadores")
    public ResponseEntity<List<Entrenador>> getEntrenadores(@RequestParam(name = "especialidad", defaultValue = "") String especialidad) {
        if (especialidad.equals("")) {
            return ResponseEntity.ok(entrenadorService.findAll());
        } else {
            boolean espe = Boolean.parseBoolean(especialidad);
            return ResponseEntity.ok(entrenadorService.findByEspecialidad(espe));
        }
    }

    @GetMapping("/gym/entrenador")
    public ResponseEntity<List<Entrenador>> getEntrenador(@RequestParam String dniEntrenador) {
        List<Entrenador> entrenador = entrenadorService.findByDniEntrenador(dniEntrenador);
        return ResponseEntity.ok(entrenador);
    }


    @PostMapping("/gym/entrenadores")
    public ResponseEntity<Entrenador> addEntrenador(@Valid @RequestBody Entrenador entrenador) throws EntrenadorNotFoundException {
        Entrenador entrenados = entrenadorService.addEntrenador(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenados);
    }

    @DeleteMapping("/gym/entrenador/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable long id) throws EntrenadorNotFoundException {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/gym/entrenador/{id}")
    public ResponseEntity<Entrenador> modifyEntrenador(@PathVariable long id, @RequestBody Entrenador entrenador) throws EntrenadorNotFoundException {
        Entrenador modifiedEntrenador = entrenadorService.modifyEntrenador(id, entrenador);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedEntrenador);
    }

    @ExceptionHandler(EntrenadorNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntrenadorNotFoundException(EntrenadorNotFoundException enfe) {
        ErrorMessage errorMessage = new ErrorMessage(404, enfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(MethodArgumentNotValidException manve) {
        ErrorMessage badRequestErrorMessage = new ErrorMessage(400, "Bad Request");
        return new ResponseEntity<>(badRequestErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(500,"Internal Server Error");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
