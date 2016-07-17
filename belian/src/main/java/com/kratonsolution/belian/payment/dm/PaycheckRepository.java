/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
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
			+ "pay.organization.id IN(:company) "
			+ "ORDER BY pay.date DESC")
	public List<Paycheck> findAll(@Param("company")List<String> company);
	
	@Query("FROM Paycheck pay WHERE "
			+ "pay.organization.id IN(:company) "
			+ "ORDER BY pay.date DESC")
	public List<Paycheck> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(pay) FROM Paycheck pay WHERE pay.organization.id IN(:company)")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM Paycheck pay WHERE "
			+ "pay.organization.id IN(:company) "
			+ "AND (pay.employment.employee.party.identity LIKE %:key% "
			+ "OR pay.employment.employee.party.name LIKE %:key%) "
			+ "ORDER BY pay.date DESC")
	public List<Paycheck> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(pay) FROM Paycheck pay WHERE "
			+ "pay.organization.id IN(:company) "
			+ "AND (pay.employment.employee.party.identity LIKE %:key% "
			+ "OR pay.employment.employee.party.name LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
