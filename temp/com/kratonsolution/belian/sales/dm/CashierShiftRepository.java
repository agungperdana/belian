/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CashierShiftRepository extends JpaRepository<CashierShift, String>
{
	@Query("FROM CashierShift shift WHERE "
			+ "shift.date =:date "
			+ "AND shift.employee.id =:employee "
			+ "AND shift.closed IS FALSE")
	public CashierShift findOne(@Param("date")Date date,@Param("employee")String employee);
	
	@Query("FROM CashierShift shift WHERE "
			+ "shift.date < :date "
			+ "AND shift.employee.id =:employee "
			+ "AND shift.closed IS FALSE")
	public List<CashierShift> findAllPendingBefore(@Param("date")Date date,@Param("employee")String employee);
}
