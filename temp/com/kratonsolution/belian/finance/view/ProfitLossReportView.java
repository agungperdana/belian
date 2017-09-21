/**
 * 
 */
package com.kratonsolution.belian.finance.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.finance.svc.ProfitLossReportService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class ProfitLossReportView
{
	@Autowired
	private ProfitLossReportService service;
	
	@RequestMapping({"/profitlossreport"})
	public String print(Model model,@RequestParam("period")String period,@RequestParam("company")String company)
	{
		model.addAllAttributes(service.generate(period, company));
		return "profitlossreport";
	}
}
