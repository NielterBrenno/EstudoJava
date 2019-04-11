package br.com.oauth2.exemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.oauth2.exemplo" })
@EntityScan(basePackages = { "br.com.oauth2.exemplo" })
@EnableJpaRepositories(basePackages = { "br.com.oauth2.exemplo" })
public class AppBoot {

	public static void main(String[] args) {
		SpringApplication.run(AppBoot.class, args);
	}

}
