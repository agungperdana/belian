/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ApproveableRepository extends JpaRepository<Approveable, String>
{
	@Query("FROM Approveable app WHERE app.approverStatus = 'SUBMITTED' ORDER BY app.date DESC")
	public List<Approveable> findAllNew();
}
