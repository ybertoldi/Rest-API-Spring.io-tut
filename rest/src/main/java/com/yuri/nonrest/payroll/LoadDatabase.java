package com.yuri.nonrest.payroll;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Logger;

@Configuration
class LoadDatabase {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDataBase(EmployeeRepository repository) {
		
		return args -> {
			log.info("preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
		};
	}

}
