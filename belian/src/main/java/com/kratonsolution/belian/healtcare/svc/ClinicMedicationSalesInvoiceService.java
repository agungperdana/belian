package com.kratonsolution.belian.healtcare.svc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.healtcare.dm.ClinicSales;
import com.kratonsolution.belian.healtcare.dm.ClinicSalesItem;
import com.kratonsolution.belian.inventory.dm.ProductType;
import com.kratonsolution.belian.ui.util.Numbers;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class ClinicMedicationSalesInvoiceService
{	
	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private Language lang;

	@Autowired
	private ClinicSalesService service;
	
	@Autowired
	private SessionUtils utils;

	@Secured({"ROLE_CLINIC_SALES_INVOICE_REPORT_READ"})
	public Map<String,Object> generate(String company,Date start,Date end)
	{
		Map<String,Object> map = new HashMap<>();

		Party selected = partyRepo.findOne(company);

		map.put("company", selected);
		map.put("start", start);
		map.put("end", end);
		map.put("title",lang.get("navbar.menu.healtcare.salesinvoice"));
		map.put("date", lang.get("generic.grid.column.date"));
		map.put("amount", lang.get("generic.grid.column.amount"));
		map.put("product", lang.get("generic.grid.column.product"));

		BigDecimal gAmt = BigDecimal.ZERO;
		BigDecimal gTuslah = BigDecimal.ZERO;
		
		List<Map<String,Object>> contents = new ArrayList<>();
		for(ClinicSales billable:service.findAllPaid(company,start,end))
		{
			BigDecimal amount = BigDecimal.ZERO;
			List<Map<String,String>> list = new ArrayList<>();
			
			for(ClinicSalesItem item:billable.getItems())
			{
				if(item.getProduct().getType().equals(ProductType.FINISHGOOD))
				{
					Map<String,String> items = new HashMap<>();
					
					if(item.getProduct().getCategory().getCode().equals("OTC"))
					{
						BigDecimal onprice = item.getPrice().divide(BigDecimal.valueOf(1.15),RoundingMode.HALF_UP);
						onprice = onprice.add(onprice.multiply(BigDecimal.valueOf(0.1)));

						items.put("product",item.getResource());
						items.put("price",Numbers.format(onprice));
						
						amount = amount.add(onprice);
					}
					else
					{
						BigDecimal onprice = item.getPrice().divide(BigDecimal.valueOf(1.2),RoundingMode.HALF_UP);
						onprice = onprice.add(onprice.multiply(BigDecimal.valueOf(0.1)));

						items.put("product",item.getResource());
						items.put("price",Numbers.format(onprice));
						
						amount = amount.add(onprice);
					}
					
					list.add(items);
				}
			}
			
			gTuslah = gTuslah.add(BigDecimal.valueOf(4000));
			gAmt = gAmt.add(amount.add(BigDecimal.valueOf(4000)));
			
			Map<String,Object> sales = new HashMap<>();
			sales.put("date", DateTimes.format(billable.getDate()));
			sales.put("tuslah", Numbers.format(BigDecimal.valueOf(4000)));
			sales.put("items",list);
			sales.put("total",Numbers.format(amount.add(BigDecimal.valueOf(4000))));
			
			contents.add(sales);
		}
		

		map.put("tuslah", Numbers.format(gTuslah));
		map.put("total", Numbers.format(gAmt));
		map.put("contents", contents);

		return map;
	}
}
