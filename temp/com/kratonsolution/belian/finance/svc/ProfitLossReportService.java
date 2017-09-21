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

import com.kratonsolution.belian.accounting.dm.AccountingPeriod;
import com.kratonsolution.belian.accounting.dm.AccountingPeriodRepository;
import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRepository;
import com.kratonsolution.belian.payment.dm.Disbursement;
import com.kratonsolution.belian.payment.dm.DisbursementRepository;
import com.kratonsolution.belian.sales.dm.Billable;
import com.kratonsolution.belian.sales.dm.BillableRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class ProfitLossReportService
{	
	@Autowired
	private CompanyStructureRepository structureRepo;

	@Autowired
	private BillableRepository billableRepository;

	@Autowired
	private DisbursementRepository disbursementRepository;

	@Autowired
	private AccountingPeriodRepository periodRepo;

	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private Language lang;

	@Autowired
	private SessionUtils utils;

	@Secured({"ROLE_PROFIT_LOSS_READ"})
	public Map<String,Object> generate(String period,String company)
	{
		Map<String,Object> map = new HashMap<>();
		
		Party selected = partyRepo.findOne(company);
		CompanyStructure cs = structureRepo.findOneByOrganizationId(company);

		Map<String,String> structureIds = new HashMap<>();

		utils.extractOrganizationId(structureIds, cs);

		map.put("income",lang.get("profitloss.label.income"));
		map.put("expense",lang.get("profitloss.label.expense"));
		map.put("company", selected);
		map.put("title",lang.get("profitloss.label.title"));
		map.put("staff",utils.getEmployee());
		map.put("date",DateTimes.currentDate());
		
		BigDecimal total = BigDecimal.ZERO;
		
		List<Map<String,Object>> contents = new ArrayList<>();
		
		AccountingPeriod ap = periodRepo.findOne(period);
		if(ap != null)
		{
			for(String com:structureIds.values())
			{
				Party party = partyRepo.findOne(com);
				
				List<Billable> incomes = billableRepository.findAllPaid(ap.getFrom(),ap.getTo(),com);
				List<Disbursement> expense = disbursementRepository.findAll(ap.getFrom(),ap.getTo(),com);
				
				if(!incomes.isEmpty() || !expense.isEmpty())
				{
					BigDecimal tIncome = BigDecimal.ZERO;
					BigDecimal tExpense = BigDecimal.ZERO;
					
					for(Billable billable:incomes)
						tIncome = tIncome.add(billable.getBillingAmount());

//					for(Disbursement disbursement:expense)
//						tExpense = tExpense.add(disbursement.getNetAmount());

					Map<String,Object> model = new HashMap<>();
					
					model.put("company", party);
					model.put("incomes",incomes);
					model.put("expenses",expense);
					model.put("netincome",tIncome);
					model.put("netexpense",tExpense);
					model.put("total", tIncome.subtract(tExpense));
					
					if(tIncome.compareTo(tExpense) >= 0)
						model.put("profitOrLost",lang.get("profitloss.label.profit"));
					else
						model.put("profitOrLost",lang.get("profitloss.label.loss"));
					
					contents.add(model);
					
					total = total.add(tIncome.subtract(tExpense));
				}
			}
		}

		map.put("total",total);
		map.put("contents", contents);
		map.put("location",utils.getLocation()!=null?utils.getLocation().getName():"Unknown Location");
		
		if(total.compareTo(BigDecimal.ZERO) >= 0)
			map.put("profitOrLost",lang.get("profitloss.label.profit"));
		else
			map.put("profitOrLost",lang.get("profitloss.label.loss"));

		return map;
	}
}
