package com.kratonsolution.belian.finance.svc;

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

import com.google.common.base.Strings;
import com.kratonsolution.belian.accounting.dm.JournalEntryRepository;
import com.kratonsolution.belian.accounting.dm.OGLAccount;
import com.kratonsolution.belian.accounting.dm.OGLAccountRepository;
import com.kratonsolution.belian.accounting.dm.OrganizationAccount;
import com.kratonsolution.belian.accounting.dm.OrganizationAccountRepository;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.general.dm.PartyRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class GeneralLedgerService
{	
	@Autowired
	private CompanyStructureRepository structureRepo;

	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private OGLAccountRepository accountRepo;
	
	@Autowired
	private JournalEntryRepository journalRepo;
	
	@Autowired
	private OrganizationAccountRepository oatRepo;
	
	@Autowired
	private Language lang;

	@Autowired
	private SessionUtils utils;

	@Secured({"ROLE_GENERAL_LEDGER_REPORT_READ"})
	public Map<String,Object> generate(String company,String account,Date start,Date end)
	{
		Map<String,Object> map = new HashMap<>();
		
		OrganizationAccount oat = oatRepo.findOne(company);
		if(oat != null)
		{
			map.put("company", oat.getOrganization());
			map.put("title",lang.get("generalledger.label.title"));
			map.put("date", lang.get("journalentry.grid.column.date"));
			map.put("debet", lang.get("journalentry.grid.column.debet"));
			map.put("credit", lang.get("journalentry.grid.column.credit"));
			
			List<Map<String,Object>> contents = new ArrayList<>();

			List<OGLAccount> postings = new ArrayList<>();
			
			if(Strings.isNullOrEmpty(account))
			{
				for(OGLAccount oglAccount:oat.getAccounts())
				{
					if(oglAccount.isSelected() && !oglAccount.getPostings().isEmpty())
						postings.add(oglAccount);
				}
			}
			else
				postings.add(accountRepo.findOne(account));
			
			if(!postings.isEmpty())
			{
				Map<String,Object> content = new HashMap<>();
				content.put("company", oat.getOrganization());
				content.put("accounts",postings);
				
				contents.add(content);
			}
			
			map.put("contents", contents);
		}

		return map;
	}
}
