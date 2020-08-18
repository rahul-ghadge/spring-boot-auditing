package com.arya.mongo.auditing.repository;

import com.arya.mongo.auditing.model.SuperHero;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;


@JaversSpringDataAuditable
public interface SuperHeroRepository extends MongoRepository<SuperHero, String> {
}