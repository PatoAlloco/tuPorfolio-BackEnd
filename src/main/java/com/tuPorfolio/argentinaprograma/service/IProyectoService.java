package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Proyecto;

public interface IProyectoService {

    void borrarProyecto(Long id);
    Proyecto editarProyecto(Long id, Proyecto proyecto) throws Exception;
}
