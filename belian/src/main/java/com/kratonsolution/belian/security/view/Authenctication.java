/**
 * 
 */
package com.kratonsolution.belian.security.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author agungdodiperdana
 *
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
