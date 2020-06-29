package com.kratonsolution.belian.geographic.impl.repository;

import java.util.List;
import java.util.Optional;

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
	
	public List<Geographic> findAllByType(@NonNull GeographicType type);
}
