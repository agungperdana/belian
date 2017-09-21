/**
 * 
 */
package com.kratonsolution.belian.payments.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PaymentRepository extends JpaRepository<Payment, String>
{
	@Query("FROM Payment pay WHERE pay.efectiveDate BETWEEN :start AND :end "
			+ "AND (pay.payer.id =:company OR pay.receiver.id =:company) "
			+ "ORDER BY pay.efectiveDate ASC ")
	public List<Payment> findAll(@Param("company")String company,@Param("start")Date start,@Param("end")Date end);
}
