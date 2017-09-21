package com.kratonsolution.belian.finance.svc;

import java.math.BigDecimal;
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

import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OGLAccountRepository;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;
import com.kratonsolution.belian.common.Language;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class TrialBalanceService
{	
	@Autowired
	private OrganizationAccountRepository repo;

	@Autowired
	private OGLAccountRepository accountRepo;
	
	@Autowired
	private Language lang;

	@Secured({"ROLE_TRIAL_BALANCE_REPORT_READ"})
	public Map<String,Object> generate(String coa,Date start,Date end)
	{
		Map<String,Object> maps = new HashMap<>();

		OrganizationAccount com = repo.findOne(coa);

		maps.put("company", com.getOrganization());
		maps.put("title",lang.get("navbar.menu.finance.trialbalance"));
		maps.put("date", end);
		maps.put("debet", lang.get("journalentry.grid.column.debet"));
		maps.put("credit", lang.get("journalentry.grid.column.credit"));
		maps.put("account", lang.get("journalentry.grid.column.account"));

		BigDecimal tDebet = BigDecimal.ZERO;
		BigDecimal tCredit = BigDecimal.ZERO;
		
		List<Map<String,Object>> contents = new ArrayList<>();
		for(OGLAccount account:accountRepo.findAllSelected(coa))
		{
			BigDecimal debet = account.getDebet(start, end);
			BigDecimal credit = account.getCredit(start, end);
			
			if(debet.compareTo(BigDecimal.ZERO) > 0 || credit.compareTo(BigDecimal.ZERO) > 0)
			{
				Map<String,Object> map = new HashMap<>();
				map.put("account",account);
				map.put("debet",debet);
				map.put("credit",credit);

				contents.add(map);
				
				tDebet = tDebet.add(debet);
				tCredit = tCredit.add(credit);
			}
		}

		maps.put("contents", contents);
		maps.put("tdebet", tDebet);
		maps.put("tcredit", tCredit);
		
		return maps;
	}
}
