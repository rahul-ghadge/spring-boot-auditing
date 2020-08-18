package com.arya.hibernate.envers.auditing.service.impl;

import com.arya.hibernate.envers.auditing.model.SuperHero;
import com.arya.hibernate.envers.auditing.repository.SuperHeroRepository;
import com.arya.hibernate.envers.auditing.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    @Autowired
    private SuperHeroRepository repository;

    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

    @Override
    public SuperHero findById(Long id) {
        return repository.findById(id).orElse(new SuperHero());
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        return repository.save(superHero);
    }

    @Override
    public void delete(Long id) {
       repository.findById(id).ifPresent(superHero -> repository.delete(superHero));
    }
}