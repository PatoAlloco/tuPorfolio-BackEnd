package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Trabajo;

public interface ITrabajoService {

    void borrarTrabajo(Long id);

    Trabajo editarTrabajo(Long id, Trabajo trabajo) throws Exception;
}
