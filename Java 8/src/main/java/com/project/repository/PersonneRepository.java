package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entity.Personnes;

public interface PersonneRepository extends JpaRepository<Personnes, Integer> {
}
