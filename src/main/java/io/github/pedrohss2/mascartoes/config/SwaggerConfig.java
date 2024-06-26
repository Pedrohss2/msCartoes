package io.github.pedrohss2.mascartoes.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS cartoes")
                        .description("Micro servico de cartoes")
                        .version("1.0.0").license(new License().name("Licensa do sistema").url("urlaleatoria.com")));
    }
}
