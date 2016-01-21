/**
 * 
 */
package com.kratonsolution.belian.sales.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.srv.CashSalesService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class CashSalesReport
{
	@Autowired
	private CashSalesService service;
	
	@RequestMapping("/cashsalesprint")
	public String print(Model model,@RequestParam("id")String id)
	{
		CashSales sales = service.findOne(id);
		
		model.addAttribute("sales",sales);
		
		return "cashsalesprint";
	}
}
