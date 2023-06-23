package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.exception.RutinaNotFoundException;

import java.util.List;

public interface RutinaService {

    List<Rutina> findAll();

    Rutina findById(long id) throws RutinaNotFoundException;
    Rutina addRutina(Rutina rutina) throws RutinaNotFoundException;
    void deleteRutina (long id) throws RutinaNotFoundException;
    Rutina modifyRutina(long id, Rutina newRutina) throws RutinaNotFoundException;

}
