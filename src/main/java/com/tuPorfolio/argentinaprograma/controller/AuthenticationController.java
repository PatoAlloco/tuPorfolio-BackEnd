package com.tuPorfolio.argentinaprograma.controller;

import com.tuPorfolio.argentinaprograma.model.Usuario;
import com.tuPorfolio.argentinaprograma.repository.UsuarioRepository;
import com.tuPorfolio.argentinaprograma.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private UsuarioService service;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthenticationController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/registro")
    public void saveUsuario(@RequestBody Usuario user) {
        this.service.registrarUsuario(user);
    }



}
