/**
 * 
 */
package com.kratonsolution.belian.payment.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.payment.svc.PaycheckService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class PaycheckPrint
{
	@Autowired
	private PaycheckService service;
	
	@RequestMapping({"/paycheckprint"})
	public String print(Model model,@RequestParam("id")String id)
	{
		model.addAttribute("title","PAYCHECK");
		model.addAttribute("paycheck",service.findOne(id));
		
		return "paycheckprint";
	}
}
