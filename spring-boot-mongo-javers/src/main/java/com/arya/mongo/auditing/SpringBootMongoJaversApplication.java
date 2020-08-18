package com.arya.mongo.auditing;

import com.arya.mongo.auditing.model.SuperHero;
import com.arya.mongo.auditing.repository.SuperHeroRepository;
import com.arya.mongo.auditing.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootMongoJaversApplication {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoJaversApplication.class, args);
    }

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {

            List<SuperHero> superHeroes = superHeroRepository.findAll();
            if (superHeroes.size() == 0) {
                LOGGER.info("******* Inserting Super heroes to DB *******");
                superHeroRepository.saveAll(HelperUtil.superHeroesSupplier.get());
            } else {
                LOGGER.info("******* Super heroes stored in DB Size :: {}", superHeroes.size());
                LOGGER.info("******* Super heroes stored in DB :: {}", superHeroes);
            }
        };
    }
}
