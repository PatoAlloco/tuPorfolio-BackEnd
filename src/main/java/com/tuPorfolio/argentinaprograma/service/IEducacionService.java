package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Educacion;


public interface IEducacionService {
    Educacion editarEstudio(Long id, Educacion estudio) throws Exception;
    void borrarEstudio(Long id);
}
