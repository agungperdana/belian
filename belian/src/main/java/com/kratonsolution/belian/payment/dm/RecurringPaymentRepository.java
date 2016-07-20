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
public interface RecurringPaymentRepository extends JpaRepository<RecurringPayment, String>
{
	@Query("FROM RecurringPayment pay WHERE "
			+ "pay.organization.id IN(:company) "
			+ "ORDER BY pay.date DESC ")
	public List<RecurringPayment> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(pay) FROM RecurringPayment pay WHERE "
			+ "pay.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM RecurringPayment pay WHERE "
			+ "pay.organization.id IN(:company) "
			+ "AND pay.name LIKE %:key% "
			+ "ORDER BY pay.date DESC ")
	public List<RecurringPayment> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(pay) FROM RecurringPayment pay WHERE "
			+ "pay.organization.id IN(:company) "
			+ "AND pay.name LIKE %:key% ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
