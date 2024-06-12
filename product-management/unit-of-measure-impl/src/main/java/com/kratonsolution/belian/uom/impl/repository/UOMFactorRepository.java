package com.kratonsolution.belian.uom.impl.repository;

import com.kratonsolution.belian.uom.impl.orm.UOMFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface UOMFactorRepository extends JpaRepository<UOMFactor, String>
{
	@Query("FROM UOMFactor factor WHERE factor.from.id =:from AND factor.to.id =:to")
	public UOMFactor findById(@Param("from")String from,@Param("to")String to);
}
