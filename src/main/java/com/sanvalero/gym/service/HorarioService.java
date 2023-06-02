package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Horario;
import com.sanvalero.gym.exception.HorarioNotFoundException;

import java.util.List;

public interface HorarioService {
    List<Horario> findAll();
    Horario findById(long id) throws HorarioNotFoundException;
    Horario addHorario(Horario horario) throws HorarioNotFoundException;
    void deleteHorario(long id) throws HorarioNotFoundException;
    Horario modifyHorario(long id, Horario newHorario) throws HorarioNotFoundException;
}
