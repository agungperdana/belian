/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.sql.Date;
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
	@Query("FROM JournalEntry entry WHERE "
			+ "entry.owner.id IN(:companys) "
			+ "ORDER BY entry.date DESC,entry.owner.name ASC ")
	public List<JournalEntry> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(entry) FROM JournalEntry entry WHERE "
			+ "entry.owner.id IN(:companys)")
	public Long count(@Param("companys")List<String> companys);
	
	@Query("FROM JournalEntry entry WHERE "
			+ "entry.owner.id IN(:companys) "
			+ "AND (entry.note LIKE %:key% "
			+ "OR entry.owner.name LIKE %:key% "
			+ "OR entry.coa.name LIKE %:key% "
			+ "OR entry.period.name LIKE %:key%) "
			+ "ORDER BY entry.date DESC,entry.owner.name ASC ")
	public List<JournalEntry> findAll(Pageable pageable,@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("SELECT COUNT(entry) FROM JournalEntry entry WHERE "
			+ "entry.owner.id IN(:companys) "
			+ "AND (entry.note LIKE %:key% "
			+ "OR entry.owner.name LIKE %:key% "
			+ "OR entry.coa.name LIKE %:key% "
			+ "OR entry.period.name LIKE %:key%) ")
	public Long count(@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("FROM JournalEntry entry WHERE "
			+ "entry.owner.id =:company "
			+ "AND entry.date BETWEEN :start AND :end "
			+ "ORDER BY entry.date DESC,entry.owner.name ASC ")
	public List<JournalEntry> findAll(@Param("company")String company,@Param("start")Date start,@Param("end")Date end);
}
