package com.arya.hibernate.envers.auditing.repository;

import com.arya.hibernate.envers.auditing.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Long> {
}
