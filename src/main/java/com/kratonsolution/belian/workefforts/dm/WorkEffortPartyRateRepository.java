/**
 * 
 */
package com.kratonsolution.belian.workefforts.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface WorkEffortPartyRateRepository extends JpaRepository<WorkEffortPartyRate, String>
{
	@Query("FROM WorkEffortPartyRate rate WHERE "
			+ "rate.party.id =:party "
			+ "AND rate.type =:type "
			+ "AND ((:date BETWEEN :start AND :end) OR (rate.start <= :date AND rate.end IS NULL)) "
			+ "ORDER BY rate.start DESC")
	public List<WorkEffortPartyRate> findAll(@Param("party")String party,@Param("type")RateType type,@Param("date")Date date);
}
