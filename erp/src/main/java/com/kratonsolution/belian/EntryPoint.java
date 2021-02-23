package com.kratonsolution.belian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class EntryPoint
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext app = SpringApplication.run(EntryPoint.class, args);
    	
    	System.out.println("************ "+app.getBean(ServletRegistrationBean.class));
    }
}
