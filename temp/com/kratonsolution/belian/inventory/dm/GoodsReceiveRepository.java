/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface GoodsReceiveRepository extends JpaRepository<GoodsReceive, String>
{
	@Query("FROM GoodsReceive receive WHERE receive.organization.id =:company ORDER BY receive.date DESC")
	public List<GoodsReceive> findAll(Pageable pageable,@Param("company")String id);
}
