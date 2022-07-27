package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Foto;
import com.tuPorfolio.argentinaprograma.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FotoService implements IFotoService{

    private FotoRepository fotoRepository;

    @Autowired
    public FotoService(FotoRepository fotoRepository){
        this.fotoRepository = fotoRepository;
    }

    @Override
    public Foto subirFoto(Foto foto) {
        return this.fotoRepository.save(foto);
    }

    public Foto subirFoto(MultipartFile archivo) throws IOException {
        Foto foto = new Foto();
        foto.setContenido(archivo.getBytes());
        foto.setMime(archivo.getContentType());
        foto.setNombre(archivo.getName());

        return this.subirFoto(foto);
    }

    @Override
    public Foto editarFoto(Long id, Foto foto) throws Exception {
        return null;
    }

    @Override
    public void borrarFoto(Long id) {
        this.fotoRepository.deleteById(id);
    }

    @Override
    public Foto getFoto(Long id) {
        return this.fotoRepository.findById(id).orElse(null);
    }
}
