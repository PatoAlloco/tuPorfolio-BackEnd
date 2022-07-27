package com.tuPorfolio.argentinaprograma.repository;

import com.tuPorfolio.argentinaprograma.model.SoftSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftSkillsRepository extends JpaRepository<SoftSkill, Long> {
}
