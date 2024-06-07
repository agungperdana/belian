package com.kratonsolution.belian.core.party.impl.repository;

import java.util.List;

import com.kratonsolution.belian.core.party.impl.orm.PartyRole;
import com.kratonsolution.belian.core.party.impl.orm.PartyRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface PartyRoleRepository extends JpaRepository<PartyRole, String>
{
	@Query("FROM PartyRole role WHERE role.type =:type")
	public List<PartyRole> findAll(@Param("type") PartyRoleType type);
}
