package com.kratonsolution.belian.uom.impl.repository;

import com.kratonsolution.belian.uom.impl.orm.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface UnitOfMeasureRepository extends JpaRepository<UnitOfMeasure, String>
{
	public UnitOfMeasure findByName(String name);
}
