package com.kratonsolution.belian.security.impl.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Controller
public class Authenctication
{		
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout()
	{
		return "redirect:/login";
	}
}
