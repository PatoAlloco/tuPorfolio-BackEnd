package com.tuPorfolio.argentinaprograma.service;

import com.tuPorfolio.argentinaprograma.model.Educacion;
import com.tuPorfolio.argentinaprograma.model.Foto;
import com.tuPorfolio.argentinaprograma.model.Proyecto;
import com.tuPorfolio.argentinaprograma.model.SoftSkill;
import com.tuPorfolio.argentinaprograma.model.Trabajo;
import com.tuPorfolio.argentinaprograma.model.Usuario;
import com.tuPorfolio.argentinaprograma.repository.UsuarioRepository;
import com.tuPorfolio.argentinaprograma.usuarioDTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    private UsuarioRepository usuarioRepository;
    private TrabajoService trabajoService;
    private SoftSkillService skillService;
    private ProyectoService proyectoService;
    private EducacionService educacionService;
    private FotoService fotoService;

    private PasswordEncoder encoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, TrabajoService trabajoService, SoftSkillService skillService,
                          ProyectoService proyectoService, EducacionService educacionService, FotoService fotoService,
                          PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.trabajoService = trabajoService;
        this.skillService = skillService;
        this.proyectoService = proyectoService;
        this.educacionService = educacionService;
        this.fotoService = fotoService;
        this.encoder = encoder;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(this.encoder.encode(usuario.getPassword()));
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuario(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return this.usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuario) throws Exception {
        if (id != null && !id.equals(usuario.getId())) {
            throw new Exception("No coincide los id");
        }

        Usuario u = this.getUsuario(id);
        usuario.setFotoPortada(u.getFotoPortada());
        usuario.setFotoPerfil(u.getFotoPerfil());

        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario editarFotoPerfil(Long id, MultipartFile archivo) throws Exception {
        Usuario u = this.getUsuario(id);
        u.setFotoPerfil(this.fotoService.subirFoto(archivo));
        return this.usuarioRepository.save(u);
    }

    @Override
    public Usuario editarFotoPortada(Long id, MultipartFile archivo) throws Exception {
        Usuario u = this.getUsuario(id);
        u.setFotoPortada(this.fotoService.subirFoto(archivo));
        return this.usuarioRepository.save(u);
    }

    public void eliminarFotoPortada(Long id, Long idFotoPortada) throws Exception {
        Usuario u = this.getUsuario(id);
        u.setFotoPortada(null);
        this.usuarioRepository.save(u);
    }

    public Foto obtenerFotoPortada(Long id) throws Exception {
        Usuario u = this.getUsuario(id);
        return u.getFotoPortada();
    }

    public Foto obtenerFotoPerfil(Long id) throws Exception {
        Usuario u = this.getUsuario(id);
        return u.getFotoPerfil();
    }


    //==================TRABAJO==========================//
    @Override
    public Usuario nuevoTrabajo(Long id, Trabajo trabajo) throws Exception {
        Usuario u = this.getUsuario(id);
        u.getTrabajos().add(trabajo);
        return this.usuarioRepository.save(u);
    }

    @Override
    public Usuario editarTrabajo(Long id, Long idTrabajo, Trabajo trabajo) throws Exception {
        Usuario u = this.getUsuario(id);
        Trabajo t = this.trabajoService.editarTrabajo(idTrabajo, trabajo);

        u.getTrabajos().remove(t);
        u.getTrabajos().add(t);

        return u;
    }

    @Override
    public Usuario borrarTrabajo(Long id, Long idTrabajo) throws Exception {
        this.trabajoService.borrarTrabajo(idTrabajo);
        return this.getUsuario(id);
    }

    //=================EDUCACION========================//
    @Override
    public Usuario nuevoEstudio(Long id, Educacion educacion) throws Exception {
        Usuario u = this.getUsuario(id);
        u.getEstudios().add(educacion);
        return this.usuarioRepository.save(u);
    }

    @Override
    public Usuario editarEstudio(Long id, Long idEstudio, Educacion estudio) throws Exception {
        Usuario u = this.getUsuario(id);
        Educacion e = this.educacionService.editarEstudio(idEstudio, estudio);

        u.getEstudios().remove(e);
        u.getEstudios().add(e);

        return u;
    }

    @Override
    public Usuario borrarEstudio(Long id, Long idEstudio) throws Exception {
        this.educacionService.borrarEstudio(idEstudio);
        return this.getUsuario(id);
    }


    //===================PROYECTOS=========================================//
    @Override
    public Usuario nuevoProyecto(Long id, Proyecto proyecto) throws Exception {
        Usuario u = this.getUsuario(id);
        u.getProyectos().add(proyecto);
        return this.usuarioRepository.save(u);
    }

    @Override
    public Usuario editarProyecto(Long id, Long idProyecto, Proyecto proyecto) throws Exception {
        Usuario u = this.getUsuario(id);
        Proyecto p = this.proyectoService.editarProyecto(idProyecto, proyecto);

        u.getProyectos().remove(p);
        u.getProyectos().add(p);

        return u;
    }

    @Override
    public Usuario borrarProyecto(Long id, Long idProyecto) throws Exception {
        this.proyectoService.borrarProyecto(idProyecto);
        return this.getUsuario(id);
    }

    //====================SOFTSKILLS=======================================//
    @Override
    public Usuario nuevaHabilidad(Long id, SoftSkill habilidad) throws Exception {
        Usuario u = this.getUsuario(id);
        u.getSkills().add(habilidad);
        return this.usuarioRepository.save(u);
    }

    @Override
    public Usuario editarHabilidad(Long id, Long idHabilidad, SoftSkill habilidad) throws Exception {
        Usuario u = this.getUsuario(id);
        SoftSkill s = this.skillService.editarHabilidad(idHabilidad, habilidad);

        u.getSkills().remove(s);
        u.getSkills().add(s);

        return u;
    }

    @Override
    public Usuario borrarHabilidad(Long id, Long idHabilidad) throws Exception {
        this.skillService.borrarHabilidad(idHabilidad);
        return this.getUsuario(id);
    }

    //=================REGUSTRO Y VALIDACIONES================//
    @Override
    public UsuarioDTO usuarioPorMail(String mail){
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setId(this.usuarioRepository.findByMail(mail).getId());
        return usuario;
    }

    private Usuario getUsuario(Long id) throws Exception {
        if (id == null) {
            throw new Exception("ID inválido");
        }

        Usuario u;
        try {
            u = this.buscarUsuario(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        if (u == null) {
            throw new Exception("Usuario inexistente");
        }

        return u;
    }
}
