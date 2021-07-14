package com.kratonsolution.belian.geographic.impl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.impl.model.Geographic;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface GeographicRepository extends JpaRepository<Geographic, String>, JpaSpecificationExecutor<Geographic> {

	public Optional<Geographic> findOneByCode(@NonNull String code);
	
	@Query("FROM Geographic geo WHERE geo.parent IS NULL ORDER BY geo.code, geo.name ASC")
	public List<Geographic> findAllRoots();
	
	@Query("FROM Geographic geo WHERE geo.parent IS NULL ORDER BY geo.code, geo.name ASC")
	public List<Geographic> findAllRoots(Pageable paging);
	
	@Query("FROM Geographic geo WHERE geo.parent IS NULL AND "
			+ "(geo.code LIKE ?1 OR geo.name LIKE ?1)  "
			+ "ORDER BY geo.code, geo.name ASC")
	public List<Geographic> findAllRoots(@NonNull String key, Pageable paging);
	
	@Query("FROM Geographic geo WHERE "
			+ "geo.code LIKE ?1 OR geo.name LIKE ?1  "
			+ "ORDER BY geo.code, geo.name ASC")
	public List<Geographic> findAll(@NonNull String key, Pageable paging);
	
	public List<Geographic> findAllByType(@NonNull GeographicType type);
}
