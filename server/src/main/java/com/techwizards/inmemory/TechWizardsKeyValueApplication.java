package com.techwizards.inmemory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableMapRepositories
@CrossOrigin
public class TechWizardsKeyValueApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechWizardsKeyValueApplication.class, args);
	}

}
