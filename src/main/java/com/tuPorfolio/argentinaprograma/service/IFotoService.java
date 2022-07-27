package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Foto;

public interface IFotoService {

    Foto subirFoto(Foto foto);
    Foto editarFoto(Long id, Foto foto) throws Exception;
    void borrarFoto(Long id);
    Foto getFoto(Long id);
}
