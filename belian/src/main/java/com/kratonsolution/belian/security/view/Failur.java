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
public class Failur
{
	@RequestMapping("/failur")
	public String fail()
	{
		return "failur";
	}
}
