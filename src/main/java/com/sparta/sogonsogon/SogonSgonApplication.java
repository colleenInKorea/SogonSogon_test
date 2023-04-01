package com.sparta.sogonsogon;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(servers = {@Server(url = "https://sogonsogon.shop", description = "Default Server URL") ,@Server(url = "http://localhost:8080", description = "Local Server URL")})
public class SogonSgonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SogonSgonApplication.class, args);
    }

}