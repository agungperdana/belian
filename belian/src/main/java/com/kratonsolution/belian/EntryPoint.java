package com.kratonsolution.belian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class EntryPoint
{
    public static void main( String[] args )
    {
    	SpringApplication.run(EntryPoint.class, args);
    }
}
