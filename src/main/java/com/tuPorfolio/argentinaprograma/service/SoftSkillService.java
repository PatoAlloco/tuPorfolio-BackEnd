package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.SoftSkill;
import com.tuPorfolio.argentinaprograma.repository.SoftSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftSkillService implements ISoftSkillService {

    private SoftSkillsRepository skillsRepository;

    @Autowired
    public SoftSkillService(SoftSkillsRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }

    @Override
    public void borrarHabilidad(Long id) {
        skillsRepository.deleteById(id);
    }

    @Override
    public SoftSkill editarHabilidad(Long id, SoftSkill softSkill) throws Exception {
        if (id != null && !id.equals(softSkill.getId())) {
            throw new Exception("No coincide los id");
        }
        return this.skillsRepository.save(softSkill);
    }
}
