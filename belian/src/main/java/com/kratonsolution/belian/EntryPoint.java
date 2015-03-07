package com.kratonsolution.belian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
public class EntryPoint
{
    public static void main( String[] args )
    {
    	SpringApplication.run(EntryPoint.class, args);
    }
}
