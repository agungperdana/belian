package com.kratonsolution.belian.party.impl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.party.impl.model.CompanyStructure;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface CompanyStructureRepository extends JpaRepository<CompanyStructure, String>
{
	public Optional<CompanyStructure> getOneByCode(@NonNull String code);
	
	@Query("FROM CompanyStructure com WHERE com.parent IS NULL ORDER BY com.code, com.name ASC")
	public List<CompanyStructure> loadAllRoot(Pageable pageable);
	
	@Query("FROM CompanyStructure com WHERE "
			+ "com.parent IS NULL AND "
			+ "(com.code LIKE ?1 OR com.name LIKE ?1 OR com.type LIKE ?1) "
			+ "ORDER BY com.code, com.name ASC")
	public List<CompanyStructure> loadAllRoot(@NonNull String key, Pageable pageable);
	
	@Query("FROM CompanyStructure com ORDER BY com.code, com.name ASC")
	public List<CompanyStructure> loadAll(Pageable pageable);
	
	@Query("FROM CompanyStructure com WHERE "
			+ "com.code LIKE ?1 OR "
			+ "com.name LIKE ?1 OR "
			+ "com.type LIKE ?1 "
			+ "ORDER BY com.code, com.name ASC")
	public List<CompanyStructure> loadAll(@NonNull String key, Pageable pageable);
}
