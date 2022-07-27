package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.SoftSkill;

public interface ISoftSkillService {

    void borrarHabilidad(Long id);
    SoftSkill editarHabilidad(Long id, SoftSkill softSkill) throws Exception;
}
