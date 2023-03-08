package com.kratonsolution.belian;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
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
@EnableTransactionManagement
@EnableCaching
@ComponentScan
public class EntryPoint
{
    public static void main( String[] args )
    {
    	new SpringApplicationBuilder(EntryPoint.class).bannerMode(Banner.Mode.OFF).run(args);
    }
}
