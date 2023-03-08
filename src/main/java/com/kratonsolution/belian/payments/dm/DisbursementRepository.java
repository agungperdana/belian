/**
 * 
 */
package com.kratonsolution.belian.payments.dm;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DisbursementRepository extends JpaRepository<Disbursement, String>
{
	@Query("FROM Disbursement disburs WHERE disburs.payer.id =:company ORDER BY disburs.number DESC")
	public List<Disbursement> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(disburs) FROM Disbursement disburs WHERE disburs.payer.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM Disbursement disburs WHERE "
			+ "disburs.payer.id =:company "
			+ "AND disburs.number LIKE %:key% "
			+ "ORDER BY disburs.number DESC")
	public List<Disbursement> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(disburs) FROM Disbursement disburs WHERE "
			+ "disburs.payer.id =:company "
			+ "AND disburs.number LIKE %:key% "
			+ "ORDER BY disburs.number DESC")
	public Long count(@Param("company")String company,@Param("key")String key);

	@Query("FROM Disbursement disburs WHERE "
			+ "disburs.payer.id =:company "
			+ "AND disburs.efectiveDate BETWEEN :from AND :to "
			+ "ORDER BY disburs.efectiveDate ASC")
	public List<Disbursement> findAll(@Param("company")String company,@Param("from")Date from,@Param("to")Date to);
}
