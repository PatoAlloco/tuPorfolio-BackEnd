package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Trabajo;
import com.tuPorfolio.argentinaprograma.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService implements ITrabajoService{

    public TrabajoRepository trabajoRepository;

    @Autowired
    public TrabajoService(TrabajoRepository trabajoRepository) {
        this.trabajoRepository = trabajoRepository;
    }

    @Override
    public void borrarTrabajo(Long id) {
        this.trabajoRepository.deleteById(id);
    }

    @Override
    public Trabajo editarTrabajo(Long id, Trabajo trabajo) throws Exception {
        if (id != null && !id.equals(trabajo.getId())) {
            throw new Exception("No coincide los id");
        }
        return this.trabajoRepository.save(trabajo);
    }
}
