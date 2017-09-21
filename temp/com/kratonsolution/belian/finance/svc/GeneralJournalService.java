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

import com.kratonsolution.belian.accounting.dm.JournalEntry;
import com.kratonsolution.belian.accounting.dm.JournalEntryRepository;
import com.kratonsolution.belian.common.Language;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.CompanyStructure;
import com.kratonsolution.belian.general.dm.CompanyStructureRepository;
import com.kratonsolution.belian.partys.dm.Party;
import com.kratonsolution.belian.partys.dm.PartyRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class GeneralJournalService
{	
	@Autowired
	private CompanyStructureRepository structureRepo;

	@Autowired
	private PartyRepository partyRepo;

	@Autowired
	private JournalEntryRepository journalRepo;
	
	@Autowired
	private Language lang;

	@Autowired
	private SessionUtils utils;

	@Secured({"ROLE_GENERAL_JOURNAL_REPORT_READ"})
	public Map<String,Object> generate(String company,Date start,Date end)
	{
		Map<String,Object> map = new HashMap<>();
		
		Party selected = partyRepo.findOne(company);
		CompanyStructure cs = structureRepo.findOneByOrganizationId(company);

		Map<String,String> structureIds = new HashMap<>();
		utils.extractOrganizationId(structureIds, cs);

		map.put("company", selected);
		map.put("title",lang.get("generaljournal.label.title"));
		map.put("date", lang.get("journalentry.grid.column.date"));
		map.put("note", lang.get("journalentry.grid.column.note"));
		map.put("ref", lang.get("journalentry.grid.column.ref"));
		map.put("debet", lang.get("journalentry.grid.column.debet"));
		map.put("credit", lang.get("journalentry.grid.column.credit"));
		
		List<Map<String,Object>> contents = new ArrayList<>();
		
		for(String com:structureIds.values())
		{
			Party party = partyRepo.findOne(com);
			if(party != null)
			{
				List<JournalEntry> entrys = journalRepo.findAll(party.getId(), start, end);
				if(!entrys.isEmpty())
				{
					Map<String,Object> content = new HashMap<>();
					content.put("company", party);
					content.put("journals",entrys);
				
					contents.add(content);
				}
			}
			
			map.put("contents", contents);
		}

		return map;
	}
}
