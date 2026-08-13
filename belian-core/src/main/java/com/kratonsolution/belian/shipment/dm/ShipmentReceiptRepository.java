
package com.kratonsolution.belian.shipment.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ShipmentReceiptRepository extends JpaRepository<ShipmentReceipt, String>
{
	@Query("FROM ShipmentReceipt receipt WHERE "
			+ "receipt.organization.id =:company "
			+ "ORDER BY receipt.date DESC")
	public List<ShipmentReceipt> findAll(Pageable pageable,@Param("company")String id);
}
