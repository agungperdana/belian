package com.kratonsolution.belian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
@EnableCaching
public class EntryPoint
{
    public static void main( String[] args )
    {
    	SpringApplication.run(EntryPoint.class, args);
    }
}
