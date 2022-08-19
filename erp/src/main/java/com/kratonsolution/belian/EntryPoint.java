package com.kratonsolution.belian;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@SpringBootApplication
@EnableR2dbcRepositories
@EnableTransactionManagement
@OpenAPIDefinition(info = @Info(title = "Belian ERP", version = "2.0", description = "API Documentation for project belian"))
public class EntryPoint {
    public static void main( String[] args ){
    	SpringApplication.run(EntryPoint.class, args);
    }
}
