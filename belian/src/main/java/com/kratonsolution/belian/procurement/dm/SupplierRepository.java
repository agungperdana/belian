/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.general.dm.Party;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SupplierRepository extends JpaRepository<Party, String>
{
	@Query("SELECT DISTINCT(prod.supplier) FROM ProductSupplier prod WHERE prod.id =:product ORDER BY prod.supplier.name ASC")
	public List<Party> findAllSupplier(@Param("product")String productId);
}
