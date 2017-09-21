/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.JournalEntry;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class AutoJournalCreatorFactory
{
	@Autowired
	private Set<AutoJournalCreator> creators;
	
	public JournalEntry create(Journalable journalable)
	{
		for(AutoJournalCreator creator:creators)
		{
			if(creator.isSupported(journalable))
				return creator.generate(journalable);
		}
		
		return null;
	}
}
