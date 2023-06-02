package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Horario;
import com.sanvalero.gym.exception.HorarioNotFoundException;
import com.sanvalero.gym.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario findById(long id) throws HorarioNotFoundException {
        return horarioRepository.findById(id)
                .orElseThrow(HorarioNotFoundException::new);
    }

    @Override
    public Horario addHorario(Horario horario) throws HorarioNotFoundException {
        return horarioRepository.save(horario);
    }

    @Override
    public void deleteHorario(long id) throws HorarioNotFoundException {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(HorarioNotFoundException::new);
        horarioRepository.delete(horario);
    }

    @Override
    public Horario modifyHorario(long id, Horario newHorario) throws HorarioNotFoundException {
        Horario existingHorario = horarioRepository.findById(id)
                .orElseThrow(HorarioNotFoundException::new);
        existingHorario.setDiaEntreno(newHorario.getDiaEntreno());
        existingHorario.setHoraEntreno(newHorario.getHoraEntreno());
        existingHorario.setAsistencia(newHorario.isAsistencia());
        existingHorario.setLocal(newHorario.getLocal());
        return horarioRepository.save(existingHorario);
    }

}
