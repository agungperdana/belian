/**
 * 
 */
package com.kratonsolution.belian.accounting.svc;

import com.kratonsolution.belian.accounting.dm.JournalEntry;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AutoJournalCreator<E extends Journalable>
{
	public boolean isSupported(Object target);
	
	public JournalEntry generate(E e);
}
