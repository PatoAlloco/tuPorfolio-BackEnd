package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Educacion;
import com.tuPorfolio.argentinaprograma.model.Foto;
import com.tuPorfolio.argentinaprograma.model.Proyecto;
import com.tuPorfolio.argentinaprograma.model.SoftSkill;
import com.tuPorfolio.argentinaprograma.model.Trabajo;
import com.tuPorfolio.argentinaprograma.model.Usuario;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> verUsuarios();

    Usuario crearUsuario(Usuario usuario);

    void borrarUsuario(Long id);

    Usuario buscarUsuario(Long id);

    Usuario editarUsuario(Long id, Usuario usuario) throws Exception;

    Usuario editarFotoPerfil(Long id, MultipartFile archivo) throws Exception;

    Usuario editarFotoPortada(Long id, MultipartFile archivo) throws Exception;

    Foto obtenerFotoPerfil(Long id) throws Exception;

    Foto obtenerFotoPortada(Long id) throws Exception;

    //====TRABAJO====//
    Usuario nuevoTrabajo(Long id, Trabajo trabajo) throws Exception;

    Usuario editarTrabajo(Long id, Long idTrabajo, Trabajo trabajo) throws Exception;

    Usuario borrarTrabajo(Long id, Long idTrabajo) throws Exception;

    //====EDUCACION====//
    Usuario nuevoEstudio(Long id, Educacion educacion) throws Exception;

    Usuario editarEstudio(Long id, Long idEstudio, Educacion estudio) throws Exception;

    Usuario borrarEstudio(Long id, Long idEstudio) throws Exception;

    //====PROYECTOS====//
    Usuario nuevoProyecto(Long id, Proyecto proyecto) throws Exception;

    Usuario editarProyecto(Long id, Long idProyecto, Proyecto proyecto) throws Exception;

    Usuario borrarProyecto(Long id, Long idProyecto) throws Exception;

    //====SOFTSKILLS=====//
    Usuario nuevaHabilidad(Long id, SoftSkill habilidad) throws Exception;

    Usuario editarHabilidad(Long id, Long idHabilidad, SoftSkill habilidad) throws Exception;

    Usuario borrarHabilidad(Long id, Long idHabilidad) throws Exception;
}
