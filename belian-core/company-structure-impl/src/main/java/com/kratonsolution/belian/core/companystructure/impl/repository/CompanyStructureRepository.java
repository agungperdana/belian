package com.kratonsolution.belian.core.companystructure.impl.repository;

import java.sql.Date;
import java.util.List;

import com.kratonsolution.belian.core.companystructure.impl.orm.CompanyStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.core.party.impl.orm.Organization;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface CompanyStructureRepository extends JpaRepository<CompanyStructure, String>
{
	@Query("FROM CompanyStructure com WHERE com.parent IS NULL ORDER BY com.organization.name ASC")
	public List<CompanyStructure> findAllParent();
	
	@Query("SELECT com.organization.id FROM CompanyStructure com")
	public List<String> findAllOrganizationId(); 
	
	public CompanyStructure findByOrganizationId(String id);

	@Query("FROM CompanyStructure com WHERE "
			+ "com.type = 'BRANCH' "
			+ "AND ((:date BETWEEN com.from AND com.to) "
			+ "OR (com.from <= :date AND com.to IS NULL)) "
			+ "ORDER BY com.organization.name ASC ")
	public List<CompanyStructure> findAllCompany(@Param("date")Date date); 

	@Query("SELECT com.organization FROM CompanyStructure com")
	public List<Organization> findAllAsOrganizations();
}
