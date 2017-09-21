/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DisbursementRepository extends JpaRepository<Disbursement, String>
{
	@Query("FROM Disbursement disb WHERE "
			+ "(disb.date BETWEEN :start AND :end) "
			+ "AND disb.organization.id =:company "
			+ "ORDER BY disb.date ASC ")
	public List<Disbursement> findAll(@Param("start")Date start,@Param("end")Date end,@Param("company")String company);
}
