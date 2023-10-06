
package com.kratonsolution.belian.geographic.impl.repository;

import java.util.List;

import com.kratonsolution.belian.geographic.impl.orm.Geographic;
import com.kratonsolution.belian.geographic.impl.orm.GeographicType;
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
