/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PaycheckRepository extends JpaRepository<Paycheck, String>
{
	@Query("FROM Paycheck pay WHERE "
			+ "pay.organization.id =:company "
			+ "ORDER BY pay.date DESC")
	public List<Paycheck> findAll(@Param("company")String company);
	
	@Query("SELECT COUNT(pay) FROM Paycheck pay WHERE pay.organization.id =:company")
	public List<Paycheck> count(@Param("company")String company);
}
