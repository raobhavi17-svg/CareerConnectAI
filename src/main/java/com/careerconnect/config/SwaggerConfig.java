package com.careerconnect.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI careerConnectAPI() {

        return new OpenAPI()

                .info(new Info()
                        .title("CareerConnectAI API")
                        .description("Campus Placement Management System Backend")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Bhavishyata Yadav")
                                .email("raobhavi17@gmail.com")))

                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repository")
                        .url("https://github.com/raobhavi17-svg/CareerConnectAI"));
    }
}
