package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Perfil;
import com.sanvalero.gym.exception.ErrorMessage;
import com.sanvalero.gym.exception.PerfilNotFoundException;
import com.sanvalero.gym.service.PerfilService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/gym/perfiles")
    public ResponseEntity<List<Perfil>> getPerfil() {
        List<Perfil> perfiles = perfilService.findAll();
        return ResponseEntity.ok(perfiles);
    }

    @PostMapping("/gym/perfiles")
    public ResponseEntity<Perfil> addPerfil(@Valid @RequestBody Perfil perfil) throws PerfilNotFoundException {
        Perfil parametros = perfilService.addPerfil(perfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(parametros);
    }

    @DeleteMapping("/gym/perfil/{id}")
    public ResponseEntity<Void> deletePerfil(@PathVariable long id) throws PerfilNotFoundException {
        perfilService.deletePerfil(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/gym/perfil/{id}")
    public  ResponseEntity<Perfil> modifyPerfil(@PathVariable long id, @RequestBody Perfil perfil) throws PerfilNotFoundException {
        Perfil modifiedPerfil = perfilService.modifyPerfil(id, perfil);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedPerfil);
    }

    @ExceptionHandler(PerfilNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePerfilNotFoundException(PerfilNotFoundException pnfe) {
        ErrorMessage errorMessage = new ErrorMessage(404, pnfe.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException (MethodArgumentNotValidException manve) {
        ErrorMessage badRequestErrorMessage = new ErrorMessage(400, "Bad Request");
        return new ResponseEntity<>(badRequestErrorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage(500,"Internal Server Error");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
