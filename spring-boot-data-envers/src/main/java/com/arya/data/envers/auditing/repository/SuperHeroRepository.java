package com.arya.data.envers.auditing.repository;

import com.arya.data.envers.auditing.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface SuperHeroRepository extends RevisionRepository<SuperHero, Long, Integer>, JpaRepository<SuperHero, Long> {
}
