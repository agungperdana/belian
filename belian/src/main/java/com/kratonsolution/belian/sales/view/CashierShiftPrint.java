/**
 * 
 */
package com.kratonsolution.belian.sales.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.sales.srv.CashierShiftService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class CashierShiftPrint
{
	@Autowired
	private CashierShiftService service;
	
	@RequestMapping({"/cashiershiftprint"})
	public String pos(Model model,@RequestParam("id")String id)
	{
		model.addAttribute("shift",service.findOne(id));
		return "cashiershiftprint";
	}
}
