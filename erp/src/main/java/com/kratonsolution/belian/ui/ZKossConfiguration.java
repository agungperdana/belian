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
	public ServletRegistrationBean<DHtmlLayoutServlet> dHtmlLayoutServlet()
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("update-uri", "/zkau");

		ServletRegistrationBean<DHtmlLayoutServlet> servlets = new ServletRegistrationBean<DHtmlLayoutServlet>(new DHtmlLayoutServlet(), "/svc/*");
		servlets.setServlet(new DHtmlLayoutServlet());
		servlets.setLoadOnStartup(1);
		servlets.setInitParameters(params);
		servlets.setName("zkLoader");

		return servlets;
	}

	@Bean
	public ServletRegistrationBean<DHtmlUpdateServlet> dHtmlUpdateServlet()
	{
		ServletRegistrationBean<DHtmlUpdateServlet> reg = new ServletRegistrationBean<DHtmlUpdateServlet>(new DHtmlUpdateServlet(), "/zkau/*");
		reg.setName("auEngine");
		return reg;
	}
}
