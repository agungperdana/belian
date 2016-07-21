package com.kratonsolution.belian.finance.svc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.PartyRepository;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class InvoiceReportService
{	
	@Autowired
	private CompanyStructureRepository structureRepo;

	@Autowired
	private BillableRepository billableRepository;

	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private Language lang;

	@Autowired
	private SessionUtils utils;

	@Secured({"ROLE_INVOICE_REPORT_READ"})
	public Map<String,Object> generate(String customer,String company)
	{
		Map<String,Object> map = new HashMap<>();
		
		Party person = partyRepo.findOne(customer);
		Party selected = partyRepo.findOne(company);
		CompanyStructure cs = structureRepo.findOneByOrganizationId(company);

		Map<String,String> structureIds = new HashMap<>();

		utils.extractOrganizationId(structureIds, cs);

		map.put("company", selected);
		map.put("title",lang.get("invoice.label.title"));
		map.put("customer",Strings.isNullOrEmpty(customer)?"All":person.getName());
		map.put("staff",utils.getEmployee());
		map.put("date",DateTimes.currentDate());
		
		BigDecimal total = BigDecimal.ZERO;
		
		List<Map<String,Object>> contents = new ArrayList<>();

		for(String com:structureIds.values())
		{
			Party party = partyRepo.findOne(com);
			
			List<Billable> incomes = new ArrayList<>();
			
			if(Strings.isNullOrEmpty(customer))
				incomes.addAll(billableRepository.findAllUnpaid(com));
			else
				incomes.addAll(billableRepository.findAllUnpaid(com,customer));
			
			if(!incomes.isEmpty())
			{
				BigDecimal tIncome = BigDecimal.ZERO;
				
				for(Billable billable:incomes)
					tIncome = tIncome.add(billable.getBillingAmount());

				Map<String,Object> model = new HashMap<>();
				
				model.put("company", party);
				model.put("incomes",incomes);
				model.put("netincome",tIncome);
				
				contents.add(model);
				
				total = total.add(tIncome);
			}
		}
		
		map.put("total",total);
		map.put("contents", contents);
		map.put("location",utils.getLocation()!=null?utils.getLocation().getName():"Unknown Location");

		return map;
	}
}
