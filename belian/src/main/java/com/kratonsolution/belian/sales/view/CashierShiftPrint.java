/**
 * 
 */
package com.kratonsolution.belian.sales.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.sales.dm.CashierShift;
import com.kratonsolution.belian.sales.srv.CashierShiftService;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class CashierShiftPrint
{
	@Autowired
	private CashierShiftService service;
	
	@RequestMapping({"/cashiershiftprint.htm"})
	public String pos(Model model,@RequestParam("id")String id)
	{
		CashierShift shift = service.findOne(id);
		
		model.addAttribute("employee",shift.getEmployee().getName());
		model.addAttribute("date",DateTimes.format(shift.getDate()));
		model.addAttribute("start",shift.getStart());
		model.addAttribute("end",shift.getEnd());
		model.addAttribute("capital",Numbers.format(shift.getCapital()));
		model.addAttribute("sales",Numbers.format(shift.getAmount()));
		model.addAttribute("tax",Numbers.format(shift.getTax()));
		model.addAttribute("total",Numbers.format(shift.getTotalAmount()));
		
		return "cashiershiftprint";
	}
}
