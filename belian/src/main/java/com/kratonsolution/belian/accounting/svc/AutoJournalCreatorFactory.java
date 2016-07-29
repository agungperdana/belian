/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
public class AutoJournalCreatorFactory
{
	@Autowired
	private Set<AutoJournalCreator> creators;
	
	public AutoJournalCreator forClass(Journalable journalable)
	{
		for(AutoJournalCreator creator:creators)
		{
			if(creator.isSupported(journalable.getClass()))
				return creator;
		}
		
		return null;
	}
}
