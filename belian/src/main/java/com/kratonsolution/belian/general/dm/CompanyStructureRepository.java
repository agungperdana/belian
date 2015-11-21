/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.global.dm.EconomicAgent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CompanyStructureRepository extends JpaRepository<CompanyStructure, String>
{
	@Query("SELECT DISTINCT(com.child.party) FROM CompanyStructure com ORDER BY com.child.party.name ASC")
	public List<EconomicAgent> findAllCompanyMembers();
}
