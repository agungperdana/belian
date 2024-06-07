package com.kratonsolution.belian.core.party.impl.repository;

import java.util.List;

import com.kratonsolution.belian.core.party.impl.orm.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface OrganizationRepository extends JpaRepository<Organization, String>
{
	@Query("FROM Organization org WHERE org.id NOT IN(:ids)")
	public List<Organization> findAllNot(@Param("ids")List<String> ids);
}
