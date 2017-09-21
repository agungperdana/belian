/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface TransferOrderRequestRepository extends JpaRepository<TransferOrderRequest, String>
{
	@Query("FROM TransferOrderRequest req WHERE req.requestStatus = 'INCOMPLETE' AND req.approverStatus = 'ACCEPTED' ORDER BY req.date DESC")
	public List<TransferOrderRequest> findAllIncomplete();
}
