/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, String>
{
	public UnitOfMeasure findOneByName(String name);
}
