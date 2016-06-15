/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SupplierRepository extends JpaRepository<Supplier, String>
{
	public Supplier findOneByPartyId(String id);
}
