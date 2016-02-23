/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface GoodsIssueRepository extends JpaRepository<GoodsIssue, String>
{
	@Query("FROM GoodsIssue issue WHERE issue.organization.id =:company ORDER BY issue.date DESC")
	public List<GoodsIssue> findAll(Pageable pageable,@Param("company")String id);
}
