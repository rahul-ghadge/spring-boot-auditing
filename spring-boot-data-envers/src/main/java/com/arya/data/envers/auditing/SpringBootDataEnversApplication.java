package com.arya.data.envers.auditing;

import com.arya.data.envers.auditing.model.SuperHero;
import com.arya.data.envers.auditing.repository.SuperHeroRepository;
import com.arya.data.envers.auditing.utils.HelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EnableTransactionManagement
public class SpringBootDataEnversApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());


	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataEnversApplication.class, args);
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
