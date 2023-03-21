package com.kratonsolution.belian.security.impl.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Controller
public class Home
{
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/")
	public String index()
	{
		return "redirect:/svc/home";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "redirect:/svc/home";
	}
}
