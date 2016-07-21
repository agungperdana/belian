/**
 * 
 */
package com.kratonsolution.belian.finance.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.finance.svc.InvoiceDueDateReportService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class InvoiceDueReportView
{
	@Autowired
	private InvoiceDueDateReportService service;
	
	@RequestMapping({"/invoiceduedatereport"})
	public String print(Model model,@RequestParam("customer")String customer,@RequestParam("company")String company)
	{
		model.addAllAttributes(service.generate(customer, company));
		return "invoiceduedatereport";
	}
}
