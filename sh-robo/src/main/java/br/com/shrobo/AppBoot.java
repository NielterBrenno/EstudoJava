package br.com.shrobo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.shrobo" })
@EntityScan(basePackages = { "br.com.shrobo" })
@EnableJpaRepositories(basePackages = { "br.com.shrobo" })
public class AppBoot {

	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}

}
