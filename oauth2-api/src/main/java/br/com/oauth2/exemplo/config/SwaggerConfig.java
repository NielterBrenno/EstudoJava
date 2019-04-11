package br.com.oauth2.exemplo.config;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${app.oauth2.urlToken}")
	private String urlToken;

	public static final String securitySchemaOAuth2 = "oauth2schema";
	public static final String authorizationScopeRead = "read";
	public static final String authorizationScopeReadDesc = "read only";
	public static final String authorizationScopeWrite = "write";

	@Bean
	public Docket RemessaApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Exemplo Oauth2").select()
				.apis(exactPackage("br.com.oauth2.exemplo.controller")).paths(PathSelectors.any())
				.build().securitySchemes(newArrayList(securitySchema()))
				.securityContexts(newArrayList(securityContext())).apiInfo(apiInfoIrec());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return new UiConfiguration(null, "list", "alpha", "schema", UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
				false, true, null);
	}

	private ApiInfo apiInfoIrec() {
		return new ApiInfoBuilder().title("Oauth2 - API").description("documentação dos serviços")
				.contact(new Contact("API", "http://www.corporação.com.br", "empresa@exemplo.com.br")).build();
	}

	@SuppressWarnings("deprecation")
	private static Predicate<RequestHandler> exactPackage(final String pkg) {
		return input -> input.declaringClass().getPackage().getName().equals(pkg);
	}

	private OAuth securitySchema() {
		List<AuthorizationScope> authorizationScopeList = newArrayList();
		authorizationScopeList.add(new AuthorizationScope("read", "read only"));
		authorizationScopeList.add(new AuthorizationScope("write", "read and write"));
		GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(urlToken);
		return new OAuth(securitySchemaOAuth2, newArrayList(authorizationScopeList), newArrayList(grantType));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(regex("/private/.*")).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope[] authorizationScopes = { new AuthorizationScope("read", "read only"),
				new AuthorizationScope("write", "read and write") };

		return newArrayList(new SecurityReference(securitySchemaOAuth2, authorizationScopes));
	}

}
