package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.exception.EntrenadorNotFoundException;
import com.sanvalero.gym.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    @Override
    public List<Entrenador> findByDniEntrenador(String dniEntrenador) {
        return entrenadorRepository.findByDniEntrenador(dniEntrenador);
    }

    @Override
    public List<Entrenador> findByEspecialidad(boolean especialidad) {
        return entrenadorRepository.findByEspecialidad(especialidad);
    }

    @Override
    public Entrenador findById(long id) throws EntrenadorNotFoundException {
        return entrenadorRepository.findById(id)
                .orElseThrow(EntrenadorNotFoundException::new);
    }

    @Override
    public Entrenador addEntrenador(Entrenador entrenador) throws EntrenadorNotFoundException {
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public void deleteEntrenador(long id) throws EntrenadorNotFoundException {
        Entrenador entrenador = entrenadorRepository.findById(id)
                        .orElseThrow(EntrenadorNotFoundException::new);
        entrenadorRepository.delete(entrenador);
    }

    @Override
    public Entrenador modifyEntrenador(long id, Entrenador newEntrenador) throws EntrenadorNotFoundException {
        Entrenador existingEntrenador = entrenadorRepository.findById(id)
                .orElseThrow(EntrenadorNotFoundException::new);
        existingEntrenador.setNombreEntrenador(newEntrenador.getNombreEntrenador());
        existingEntrenador.setApellidoEntrenador(newEntrenador.getApellidoEntrenador());
        existingEntrenador.setDniEntrenador(newEntrenador.getDniEntrenador());
        existingEntrenador.setEdad(newEntrenador.getEdad());
        existingEntrenador.setEspecialidad(newEntrenador.isEspecialidad());
        return entrenadorRepository.save(existingEntrenador);
    }


}
