package com.kratonsolution.belian.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Configuration
public class ZKossConfiguration
{	
	@Bean
	public ServletRegistrationBean dHtmlLayoutServlet() 
	{
		List<String> urls = new ArrayList<String>();
		urls.add("/svc/*");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("update-uri", "/zkau");

		ServletRegistrationBean servlets = new ServletRegistrationBean();
		servlets.setServlet(new DHtmlLayoutServlet());
		servlets.setLoadOnStartup(1);
		servlets.setInitParameters(params);
		servlets.setName("ZKoss");
		servlets.setUrlMappings(urls);
		
		return servlets;
	}

	@Bean
	public ServletRegistrationBean dHtmlUpdateServlet() 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("update-uri", "/zkau/*");
		ServletRegistrationBean reg = new ServletRegistrationBean(new DHtmlUpdateServlet(), "/zkau/*");
		reg.setLoadOnStartup(2);
		reg.setInitParameters(params);
		return reg;
	}
}
