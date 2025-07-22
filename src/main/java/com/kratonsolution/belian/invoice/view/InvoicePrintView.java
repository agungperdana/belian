package com.kratonsolution.belian.invoice.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.global.view.AbstractView;
import com.kratonsolution.belian.invoice.dm.Invoice;
import com.kratonsolution.belian.invoice.dm.InvoiceRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class InvoicePrintView extends AbstractView
{
	@Autowired
	private InvoiceRepository service;
	
	@RequestMapping("/salesinvoiceprint")
	public String soprint(Model model,@RequestParam("id")String id)
	{
		model.addAttribute("inv", service.findById(id));
		model.addAttribute("util", utils);
		model.addAttribute("title",lang.get("invoices.grid.column.print.title.sales"));
		
		return "invoiceprint";
	}
	
	@RequestMapping("/purchaseinvoiceprint")
	public String poprint(Model model,@RequestParam("id")String id)
	{
		Invoice invoice = service.findById(id).orElse(null);
		
		model.addAttribute("inv",invoice);
		model.addAttribute("util", utils);
		model.addAttribute("title",lang.get("invoices.grid.column.print.title.purchase"));
		
		return "invoiceprint";
	}
}
