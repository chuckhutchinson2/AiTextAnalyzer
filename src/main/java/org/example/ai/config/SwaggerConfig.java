package org.example.ai.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// http://localhost/swagger-ui/index.html
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        String contactName = "Chuck Hutchinson";
        String linkedInURL = "https://www.linkedin.com/in/";

        // You might want to evaluate which license to use
        // https://www.gnu.org/licenses/licenses.en.html#GPL
        String licenseURL = "https://www.gnu.org/licenses/gpl-3.0.html";
        return new OpenAPI().info(
                new Info().title("TextAnalyzer")
                        .description("Text Analyzer")
                        .summary("This is a sample spring boot REST application with Jacoco, Swagger showing a sample Controller, Service and Repository")
                        .version("v1.0")
                        .contact(new Contact().name(contactName).url(linkedInURL))
                        .license(new License().url(licenseURL))
        ).addServersItem(new Server().url("/"));
    }
}
