package com.tuPorfolio.argentinaprograma.security;

import com.tuPorfolio.argentinaprograma.model.Usuario;
import com.tuPorfolio.argentinaprograma.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationConfig implements UserDetailsService {
    private UsuarioRepository repository;

    @Autowired
    public AuthenticationConfig(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String m) throws UsernameNotFoundException {
        Usuario usuario = repository.findByMail(m);
        if (usuario == null){
            throw new UsernameNotFoundException("El usuario con mail " + m + " no existe.");
        }
        return usuario;
    }


}