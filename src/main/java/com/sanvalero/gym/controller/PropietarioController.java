package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Propietario;
import com.sanvalero.gym.exception.ErrorMessage;
import com.sanvalero.gym.exception.PerfilNotFoundException;
import com.sanvalero.gym.exception.PropietarioNotFoundException;
import com.sanvalero.gym.service.PropietarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/gym/propietarios")
    public ResponseEntity<List<Propietario>> getPropietario() {
        List<Propietario> propietarios = propietarioService.findAll();
        return ResponseEntity.ok(propietarios);
    }

    @PostMapping("/gym/propietarios")
    public ResponseEntity<Propietario> addPropietario(@Valid @RequestBody Propietario propietario) throws PropietarioNotFoundException {
        Propietario jefes = propietarioService.addPropietario(propietario);
        return ResponseEntity.status(HttpStatus.CREATED).body(jefes);
    }

    @DeleteMapping("/gym/propietario/{id}")
    public ResponseEntity<Void> deletePropietario(@PathVariable long id) throws PropietarioNotFoundException {
        propietarioService.deletePropietario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/gym/propietario/{id}")
    public ResponseEntity<Propietario> modifyPropietario(@PathVariable long id, @RequestBody Propietario propietario) throws PropietarioNotFoundException {
        Propietario modifiedPropietario = propietarioService.modifyPropietario(id, propietario);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedPropietario);
    }

    @ExceptionHandler(PropietarioNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePropietarioNotFoundException(PropietarioNotFoundException pnfe) {
        ErrorMessage errorMessage = new ErrorMessage(404,pnfe.getMessage());
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

