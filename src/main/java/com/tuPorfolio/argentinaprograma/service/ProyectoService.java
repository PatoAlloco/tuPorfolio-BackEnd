package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Proyecto;
import com.tuPorfolio.argentinaprograma.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    private ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto editarProyecto(Long id, Proyecto proyecto) throws Exception {
        if (id != null && !id.equals(proyecto.getId())) {
            throw new Exception("No coincide los id");
        }
        return this.proyectoRepository.save(proyecto);
    }
}
