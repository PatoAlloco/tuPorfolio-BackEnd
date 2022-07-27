package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Educacion;
import com.tuPorfolio.argentinaprograma.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    private EducacionRepository educacionRepository;

    @Autowired
    public EducacionService(EducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }

    @Override
    public Educacion editarEstudio(Long id, Educacion estudio) throws Exception {
        if (id != null && !id.equals(estudio.getId())) {
            throw new Exception("No coincide los id");
        }
        return this.educacionRepository.save(estudio);
    }

    @Override
    public void borrarEstudio(Long id) {
        educacionRepository.deleteById(id);
    }
}
