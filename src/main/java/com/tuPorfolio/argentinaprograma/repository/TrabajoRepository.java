package com.tuPorfolio.argentinaprograma.repository;

import com.tuPorfolio.argentinaprograma.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long> {
}
