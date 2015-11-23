/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface JournalEntryRepository extends JpaRepository<JournalEntry, String>
{
	@Query("FROM JournalEntry entry WHERE entry.owner.id IN :companys")
	public List<JournalEntry> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(journal) FROM JournalEntry journal WHERE journal.owner.id IN :companys")
	public int count(@Param("companys")List<String> companys);
}
