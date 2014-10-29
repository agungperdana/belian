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
public class Home
{
	@RequestMapping("/")
	public String index()
	{
		return "home";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
}
