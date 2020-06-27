package com.kratonsolution.belian.party.impl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.party.impl.model.Organization;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface OrganizationRepository extends JpaRepository<Organization, String>, JpaSpecificationExecutor<Organization>
{
	@Query("FROM Organization org WHERE org.party.code = ?1")
	public Optional<Organization> findByCode(@NonNull String code);
	
}
