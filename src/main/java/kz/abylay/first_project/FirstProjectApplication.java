package kz.abylay.first_project;

import kz.abylay.first_project.models.Country;
import kz.abylay.first_project.repository.CountryRepository;
import kz.abylay.first_project.service.impl.CountryServiceImpl;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

}
