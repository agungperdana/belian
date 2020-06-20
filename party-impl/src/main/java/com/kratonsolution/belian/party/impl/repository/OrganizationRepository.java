package com.kratonsolution.belian.party.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.party.impl.model.Organization;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface OrganizationRepository extends JpaRepository<Organization, String>
{
	@Query("FROM Organization org WHERE org.id NOT IN(:ids)")
	public List<Organization> findAllNot(@Param("ids")List<String> ids);
}
