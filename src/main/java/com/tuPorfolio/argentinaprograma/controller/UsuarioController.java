package com.tuPorfolio.argentinaprograma.controller;

import com.tuPorfolio.argentinaprograma.model.Educacion;
import com.tuPorfolio.argentinaprograma.model.Foto;
import com.tuPorfolio.argentinaprograma.model.Proyecto;
import com.tuPorfolio.argentinaprograma.model.SoftSkill;
import com.tuPorfolio.argentinaprograma.model.Trabajo;
import com.tuPorfolio.argentinaprograma.model.Usuario;
import com.tuPorfolio.argentinaprograma.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    private IUsuarioService usuarioService;

    @Autowired
    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //esto practicamente no lo voy a usar
    @GetMapping()
    @ResponseBody
    public List<Usuario> verUsuarios() {
        return usuarioService.verUsuarios();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Usuario> verUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(this.usuarioService.buscarUsuario(id), HttpStatus.OK);
    }

    //lo utilizo la primera vez cuando creo el primer usuario con los atributos del constructor que cree
    @PostMapping()
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(this.usuarioService.crearUsuario(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity borrarUsuario(@PathVariable Long id) {
        this.usuarioService.borrarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //aca le agrego el resto de los atributos que no sean foto
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarUsuario(id, usuario), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //edito el usuario con la foto de portada
    @PatchMapping("/{id}/foto-portada")
    public ResponseEntity<Usuario> editarFotoPortada(@PathVariable Long id, MultipartFile archivo) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarFotoPortada(id, archivo), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //edito usuario foto de perfil
    @PatchMapping("/{id}/foto-perfil")
    public ResponseEntity<Usuario> editarFotoPerfil(@PathVariable Long id, MultipartFile archivo) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarFotoPerfil(id, archivo), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/foto-portada")
    public ResponseEntity<Foto> obtenerFotoPortada(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.usuarioService.obtenerFotoPortada(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //edito usuario foto de perfil
    @GetMapping("/{id}/foto-perfil")
    public ResponseEntity<Foto> obtenerFotoPerfil(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.usuarioService.obtenerFotoPerfil(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //=====================TRABAJOS====================//
    @PostMapping("/{id}/trabajo")
    public ResponseEntity<Usuario> nuevoTrabajo(@PathVariable Long id, @RequestBody Trabajo trabajo) {
        try {
            return new ResponseEntity<>(this.usuarioService.nuevoTrabajo(id, trabajo), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}/trabajo/{idTrabajo}")
    public ResponseEntity<Usuario> editarTrabajo(@PathVariable Long id, @PathVariable Long idTrabajo, @RequestBody Trabajo trabajo) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarTrabajo(id, idTrabajo, trabajo), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/trabajo/{idTrabajo}")
    public ResponseEntity<Usuario> borrarTrabajo(@PathVariable Long id, @PathVariable Long idTrabajo) throws Exception {
        try {
            return new ResponseEntity<>(this.usuarioService.borrarTrabajo(id, idTrabajo), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //==================EDUCACION===========================//
    @PostMapping("/{id}/educacion")
    public ResponseEntity<Usuario> nuevoEstudio(@PathVariable Long id, @RequestBody Educacion educacion) {
        try {
            return new ResponseEntity<>(this.usuarioService.nuevoEstudio(id, educacion), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}/educacion/{idEstudio}")
    public ResponseEntity<Usuario> editarEstudio(@PathVariable Long id, @PathVariable Long idEstudio, @RequestBody Educacion estudio) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarEstudio(id, idEstudio, estudio), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/educacion/{idEstudio}")
    public ResponseEntity<Usuario> borrarEstudio(@PathVariable Long id, @PathVariable Long idEstudio) throws Exception {
        try {
            return new ResponseEntity<>(this.usuarioService.borrarEstudio(id, idEstudio), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //===============PROYECTOS=============//

    @PostMapping("/{id}/proyecto")
    public ResponseEntity<Usuario> nuevoProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        try {
            return new ResponseEntity<>(this.usuarioService.nuevoProyecto(id, proyecto), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}/proyecto/{idProyecto}")
    public ResponseEntity<Usuario> editarProyecto(@PathVariable Long id, @PathVariable Long idProyecto, @RequestBody Proyecto proyecto) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarProyecto(id, idProyecto, proyecto), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/proyecto/{idProyecto}")
    public ResponseEntity<Usuario> borrarProyecto(@PathVariable Long id, @PathVariable Long idProyecto) throws Exception {
        try {
            return new ResponseEntity<>(this.usuarioService.borrarProyecto(id, idProyecto), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //====================SOFTSKILLS=======================================//

    @PostMapping("/{id}/softskill")
    public ResponseEntity<Usuario> nuevaHabilidad(@PathVariable Long id, @RequestBody SoftSkill habilidad) {
        try {
            return new ResponseEntity<>(this.usuarioService.nuevaHabilidad(id, habilidad), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("{id}/softskill/{idHabilidad}")
    public ResponseEntity<Usuario> editarHabilidad(@PathVariable Long id, @PathVariable Long idHabilidad, @RequestBody SoftSkill habilidad) {
        try {
            return new ResponseEntity<>(this.usuarioService.editarHabilidad(id, idHabilidad, habilidad), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/softskill/{idHabilidad}")
    public ResponseEntity<Usuario> borrarHabilidad(@PathVariable Long id, @PathVariable Long idHabilidad) throws Exception {
        try {
            return new ResponseEntity<>(this.usuarioService.borrarHabilidad(id, idHabilidad), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}