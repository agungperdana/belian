/**
 * 
 */
package com.kratonsolution.belian.security.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class Failur
{
	@RequestMapping("/failur")
	public String fail()
	{
		return "redirect:/svc/error";
	}
}
