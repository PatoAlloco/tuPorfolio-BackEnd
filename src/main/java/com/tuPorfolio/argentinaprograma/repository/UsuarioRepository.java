package com.tuPorfolio.argentinaprograma.repository;

import com.tuPorfolio.argentinaprograma.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByMail(String mail);
}
