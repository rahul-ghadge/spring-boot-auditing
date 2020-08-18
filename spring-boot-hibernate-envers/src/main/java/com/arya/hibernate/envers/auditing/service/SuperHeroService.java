package com.arya.hibernate.envers.auditing.service;


import com.arya.hibernate.envers.auditing.model.SuperHero;

import java.util.List;

public interface SuperHeroService {

    List<?> findAll();

    SuperHero findById(Long id);

    SuperHero save(SuperHero superHero);

    SuperHero update(SuperHero superHero);

    void delete(Long id);
}