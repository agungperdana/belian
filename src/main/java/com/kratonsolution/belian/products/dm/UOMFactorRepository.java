
package com.kratonsolution.belian.products.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface UOMFactorRepository extends JpaRepository<UOMFactor, String>
{
	@Query("FROM UOMFactor factor WHERE factor.from.id =:from AND factor.to.id =:to")
	public UOMFactor findById(@Param("from")String from,@Param("to")String to);
}
