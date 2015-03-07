/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Agung Dodi Perdana
 *
 */
public interface PartyRepository extends JpaRepository<Party,String>
{	
	public List<Party> findAllByRolesTypeName(String name);
}
