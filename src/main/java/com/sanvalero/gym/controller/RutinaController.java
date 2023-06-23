package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.exception.ErrorMessage;
import com.sanvalero.gym.exception.RutinaNotFoundException;
import com.sanvalero.gym.service.RutinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping("/gym/rutinas")
    public ResponseEntity<List<Rutina>> getRutina() {
        List<Rutina> rutinas = rutinaService.findAll();
        return ResponseEntity.ok(rutinas);
    }

    @PostMapping("/gym/rutinas")
    public ResponseEntity<Rutina> addRutina(@Valid @RequestBody Rutina rutina) throws RutinaNotFoundException {
        Rutina tablas = rutinaService.addRutina(rutina);
        return ResponseEntity.status(HttpStatus.CREATED).body(tablas);
    }

    @DeleteMapping("/gym/rutina/{id}")
    public ResponseEntity<Void> deleteRutina(@PathVariable long id) throws RutinaNotFoundException {
        rutinaService.deleteRutina(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/gym/rutina/{id}")
    public ResponseEntity<Rutina> modifyRutina(@PathVariable long id, @RequestBody Rutina rutina) throws RutinaNotFoundException {
        Rutina modifiedRutina = rutinaService.modifyRutina(id, rutina);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedRutina);
    }

    @ExceptionHandler(RutinaNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleRutinaNotFoundException(RutinaNotFoundException rnfe) {
        ErrorMessage errorMessage = new ErrorMessage(404, rnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(MethodArgumentNotValidException manve) {
        ErrorMessage badRequestErrorMessage = new ErrorMessage(400, "Bad Request");
        return new ResponseEntity<>(badRequestErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(500, "Internal Server Error");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
