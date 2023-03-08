/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PartyRoleRepository extends JpaRepository<PartyRole, String>
{
	@Query("FROM PartyRole role WHERE role.type =:type")
	public List<PartyRole> findAll(@Param("type")PartyRoleType type);
}
