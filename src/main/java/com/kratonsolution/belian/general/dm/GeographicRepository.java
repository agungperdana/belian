/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface GeographicRepository extends JpaRepository<Geographic, String> 
{
	public List<Geographic> findAllByType(GeographicType type);
}
