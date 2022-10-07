package com.kratonsolution.belian.security.access.user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "Belian ERP Access User", version = "2.0.1", description = "API Documentation for project Access User"))
public class AccessUserEntryPoint {

    public static void main(String[] args) {
        SpringApplication.run(AccessUserEntryPoint.class, args);
    }
}