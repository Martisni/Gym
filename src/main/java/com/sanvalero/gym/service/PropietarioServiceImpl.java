package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Propietario;
import com.sanvalero.gym.exception.PropietarioNotFoundException;
import com.sanvalero.gym.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> findAll() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario findById(long id) throws PropietarioNotFoundException {
        return propietarioRepository.findById(id)
                .orElseThrow(PropietarioNotFoundException::new);
    }

    @Override
    public Propietario addPropietario(Propietario propietario) throws PropietarioNotFoundException {
        return propietarioRepository.save(propietario);
    }

    @Override
    public void deletePropietario(long id) throws PropietarioNotFoundException {
        Propietario propietario = propietarioRepository.findById(id)
                .orElseThrow(PropietarioNotFoundException::new);
        propietarioRepository.delete(propietario);
    }

    @Override
    public Propietario modifyPropietario(long id, Propietario newPropietario) throws PropietarioNotFoundException {
        Propietario existingPropietario = propietarioRepository.findById(id)
                .orElseThrow(PropietarioNotFoundException::new);
        existingPropietario.setNombrePropietario(newPropietario.getNombrePropietario());
        existingPropietario.setNif(newPropietario.getNif());
        existingPropietario.setNumeroEmpleados(newPropietario.getNumeroEmpleados());
        existingPropietario.setNumeroEstablecimiento(newPropietario.getNumeroEstablecimiento());
        existingPropietario.setFechaPagos(newPropietario.getFechaPagos());
        return propietarioRepository.save(existingPropietario);
    }
}
