
package com.kratonsolution.belian.requirement.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.global.dm.StatusType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface WorkRequirementRepository	extends JpaRepository<WorkRequirement, String>
{
	@Query("FROM WorkRequirement work WHERE "
			+ "work.organization.id =:company "
			+ "ORDER BY work.creationDate DESC ")
	public List<WorkRequirement> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(work) FROM WorkRequirement work WHERE "
			+ "work.organization.id =:company ")
	public Long count(@Param("company")String company);
	
	@Query("SELECT DISTINCT work FROM WorkRequirement work LEFT JOIN work.statuses st WHERE st.type NOT IN(:statuses) "
			+ "ORDER BY work.number ASC, work.creationDate DESC")
	public List<WorkRequirement> findAllOpen(@Param("statuses")List<StatusType> status);
	
	@Query("SELECT DISTINCT work FROM WorkRequirement work INNER JOIN work.statuses status WHERE "
			+ "work.organization.id =:company "
			+ "AND status.type NOT IN('FULFILLED','DONE','CANCELED','INACTIVE','ONHOLD') "
			+ "ORDER BY work.number ASC, work.creationDate DESC")
	public List<WorkRequirement> findAllForWorkEfforts(@Param("company")String company);
}
