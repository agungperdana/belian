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
public interface GoodsTransferRepository extends JpaRepository<GoodsTransfer, String>
{
	@Query("FROM GoodsTransfer gt WHERE gt.source.id =:company ORDER BY gt.date DESC,gt.number ASC")
	public List<GoodsTransfer> findAll(Pageable pageable,@Param("company")String company);
}
