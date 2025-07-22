
package com.kratonsolution.belian.global.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ProductReceiveableRepository extends JpaRepository<ProductReceiveable, String>
{
	@Query("FROM ProductReceiveable rec WHERE rec.organization.id =:company AND rec.status = 'NEW' ORDER BY rec.date DESC")
	public List<ProductReceiveable> findAllNew(@Param("company")String company);
}
