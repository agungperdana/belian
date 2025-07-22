
package com.kratonsolution.belian.invoice.view;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.general.svc.CompanyStructureService;
import com.kratonsolution.belian.global.view.AbstractView;
import com.kratonsolution.belian.invoice.dm.SalesInvoice;
import com.kratonsolution.belian.invoice.svc.SalesInvoiceService;
import com.kratonsolution.belian.partys.dm.PartyRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Controller
public class InvoiceReportView extends AbstractView
{
	@Autowired
	private SalesInvoiceService service;

	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private CompanyStructureService structureService;

	@RequestMapping("/salesinvoicereportview")
	public String receiptreportview(Model model,
			@RequestParam("organization")String organization,
			@RequestParam("from")String from,
			@RequestParam("to")String to,
			@RequestParam("paid")boolean paid,
			@RequestParam("customer")String customer) throws Exception
	{
		List<Map<String,Object>> lists = new ArrayList<Map<String,Object>>();

		BigDecimal grand = BigDecimal.ZERO;

		model.addAttribute("title",lang.get("invoices.grid.column.report.title.sales"));
		model.addAttribute("company",partyRepo.findById(organization));
		model.addAttribute("customer",partyRepo.findById(customer));
		model.addAttribute("from",from);
		model.addAttribute("to",to);
		model.addAttribute("datas", lists);
		model.addAttribute("total", grand);

		Date _from = DateTimes.parse(from);
		Date _to = DateTimes.parse(to);

		List<String> companys = new ArrayList<>();
		companys.add(organization);
		companys.addAll(structureService.findAllChild(organization));

		for(String company:companys)
		{
			List<SalesInvoice> invoices = service.findAll(company,customer, _from, _to);

			List<SalesInvoice> temp = new ArrayList();
			if(paid)
				temp.addAll(invoices);
			else
			{
				for(SalesInvoice invoice:invoices)
				{
					if(!invoice.isPaid())
						temp.add(invoice);
				}
			}

			if(!invoices.isEmpty())
			{
				Map<String,Object> map = new HashMap<>();
				map.put("company",partyRepo.findById(company));
				map.put("invoices",temp);

				BigDecimal total = BigDecimal.ZERO;

				for(SalesInvoice invoice:temp)
					total = total.add(invoice.getSubtotal());

				map.put("total",total);

				grand = grand.add(total);

				lists.add(map);
			}
		}

		return "salesinvoicereport";
	}
}
