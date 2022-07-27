package com.tuPorfolio.argentinaprograma.repository;

import com.tuPorfolio.argentinaprograma.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
}
