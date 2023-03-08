
package com.kratonsolution.belian.global.infra;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Configuration
public class FiltersConfiguration
{
	@Bean
	public FilterRegistrationBean openSessionInViewFilter()
	{
		Collection<String> urls = new HashSet<String>();
		urls.add("/*");
		
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new OpenEntityManagerInViewFilter());
		bean.setUrlPatterns(urls);
		
		return bean;
	}
}
