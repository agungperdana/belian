/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface JournalPostingRepository extends JpaRepository<JournalPosting, String>
{
	@Query("FROM JournalPosting posting WHERE "
			+ "posting.account.id =:account "
			+ "AND (posting.date BETWEEN :start AND :end) "
			+ "ORDER BY posting.date DESC ")
	public List<JournalPosting> findAll(@Param("account")String account,@Param("start")Date start,@Param("end")Date end);
}
