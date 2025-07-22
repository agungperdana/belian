
package com.kratonsolution.belian.products.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, String>
{
	public UnitOfMeasure findByName(String name);
}
