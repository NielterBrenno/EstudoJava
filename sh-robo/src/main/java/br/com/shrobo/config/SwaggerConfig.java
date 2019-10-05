package br.com.shrobo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket RemessaApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("SH API").select()
				.apis(exactPackage("br.com.shrobo.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfoIrec());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return new UiConfiguration(null, "list", "alpha", "schema", UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
				false, true, null);
	}

	private ApiInfo apiInfoIrec() {
		return new ApiInfoBuilder().title("SH - API").description("documentação dos serviços")
				.contact(new Contact("API", "http://www.corporação.com.br", "empresa@exemplo.com.br")).build();
	}

	@SuppressWarnings("deprecation")
	private static Predicate<RequestHandler> exactPackage(final String pkg) {
		return input -> input.declaringClass().getPackage().getName().equals(pkg);
	}

}
