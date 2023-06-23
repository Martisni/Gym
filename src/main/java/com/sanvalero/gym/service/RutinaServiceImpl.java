package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.exception.RutinaNotFoundException;
import com.sanvalero.gym.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Override
    public List<Rutina> findAll() {
        return rutinaRepository.findAll();
    }

    @Override
    public Rutina findById(long id) throws RutinaNotFoundException {
        return rutinaRepository.findById(id)
                .orElseThrow(RutinaNotFoundException::new);
    }

    @Override
    public Rutina addRutina(Rutina rutina) throws RutinaNotFoundException {
        return rutinaRepository.save(rutina);
    }

    @Override
    public void deleteRutina(long id) throws RutinaNotFoundException {
        Rutina rutina = rutinaRepository.findById(id)
                .orElseThrow(RutinaNotFoundException::new);
        rutinaRepository.delete(rutina);
    }

    @Override
    public Rutina modifyRutina(long id, Rutina newRutina) throws RutinaNotFoundException {
        Rutina existingRutina = rutinaRepository.findById(id)
                .orElseThrow(RutinaNotFoundException::new);
        existingRutina.setDiasEntrenados(newRutina.getDiasEntrenados());
        existingRutina.setDuracion(newRutina.getDuracion());
        existingRutina.setModalidad(newRutina.getModalidad());
        existingRutina.setNumeroRepeticiones(newRutina.getNumeroRepeticiones());
        existingRutina.setNumeroSeries(newRutina.getNumeroRepeticiones());
        existingRutina.setMaterial(newRutina.isMaterial());
        return rutinaRepository.save(existingRutina);
    }
}
