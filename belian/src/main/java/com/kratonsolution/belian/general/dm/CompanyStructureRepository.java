/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CompanyStructureRepository extends JpaRepository<CompanyStructure, String>
{
	@Query("FROM CompanyStructure com WHERE com.parent IS NULL ORDER BY com.organization.name ASC")
	public List<CompanyStructure> findAllParent();
	
	@Query("SELECT com.organization.id FROM CompanyStructure com")
	public List<String> findAllOrganizationId(); 
	
	public CompanyStructure findOneByOrganizationId(String id);
}
