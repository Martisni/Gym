package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Horario;
import com.sanvalero.gym.exception.ErrorMessage;
import com.sanvalero.gym.exception.HorarioNotFoundException;
import com.sanvalero.gym.service.HorarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/gym/horarios")
    public ResponseEntity<List<Horario>> getHorario() {
        List<Horario> horarios = horarioService.findAll();
        return ResponseEntity.ok(horarios);
    }

    @PostMapping("/gym/horarios")
    public ResponseEntity<Horario> addHorario(@Valid @RequestBody Horario horario) throws HorarioNotFoundException {
        Horario tiempos = horarioService.addHorario(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(tiempos);
    }

    @DeleteMapping("/gym/horario/{id}")
    public ResponseEntity<Void> deleteHorario(@PathVariable long id) throws HorarioNotFoundException {
        horarioService.deleteHorario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/gym/horario/{id}")
    public ResponseEntity<Horario> modifyHorario(@PathVariable long id, @RequestBody Horario horario) throws HorarioNotFoundException {
        Horario modifiedHorario = horarioService.modifyHorario(id, horario);
        return ResponseEntity.status(HttpStatus.OK).body(modifiedHorario);
    }

    @ExceptionHandler(HorarioNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleHorarioNotFoundException(HorarioNotFoundException hnfe) {
        ErrorMessage errorMessage = new ErrorMessage(404, hnfe.getMessage());
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
