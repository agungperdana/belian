package com.kratonsolution.belian.security.access.module;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "Belian ERP Access Module", version = "2.0.1", description = "API Documentation for project Access module"))
public class AccessModuleEntryPoint {

    public static void main(String[] args) {
        SpringApplication.run(AccessModuleEntryPoint.class, args);
    }
}
