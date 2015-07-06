/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author agungdodiperdana
 *
 */
public interface PositionRepository extends JpaRepository<Position, String>
{
	@Query("FROM Position pos WHERE pos.id != :id")
	public List<Position> findAllNotEqual(@Param("id")String positionId);
}
