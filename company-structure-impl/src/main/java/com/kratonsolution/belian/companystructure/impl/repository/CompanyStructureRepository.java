package com.kratonsolution.belian.companystructure.impl.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.companystructure.impl.model.CompanyStructure;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
public interface CompanyStructureRepository extends JpaRepository<CompanyStructure, String> {

	public Optional<CompanyStructure> findOneByPartyCode(@NonNull String partyCode);
	
	@Query("FROM CompanyStructure cm WHERE cm.parentPartyCode IS NULL ORDER BY cm.partyName ASC")
	public List<CompanyStructure> findAllRoots();
	
	@Query("FROM CompanyStructure cm WHERE cm.parentPartyCode = ?1 ORDER BY cm.partyName ASC")
	public List<CompanyStructure> findAllChild(@NonNull String parent);
	
	@Query("FROM CompanyStructure cm WHERE cm.partyCode LIKE ?1 OR "
			+ "cm.partyName LIKE ?1 OR "
			+ "cm.parentPartyCode LIKE ?1 OR "
			+ "cm.parentPartyName LIKE ?1 "
			+ "ORDER BY cm.partyName ASC")
	public List<CompanyStructure> findAll(@NonNull String key, Pageable paging);
	
	@Query("SELECT COUNT(cm) FROM CompanyStructure cm WHERE cm.partyCode LIKE ?1 OR "
			+ "cm.partyName LIKE ?1 OR "
			+ "cm.parentPartyCode LIKE ?1 OR "
			+ "cm.parentPartyName LIKE ?1 ")
	public Long count(@NonNull String key);	
}
