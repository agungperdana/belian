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
public interface ReceiptRepository extends JpaRepository<Receipt, String>
{
	@Query("FROM Receipt ceipt WHERE ceipt.receiver.id =:company ORDER BY ceipt.number DESC")
	public List<Receipt> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(ceipt) FROM Receipt ceipt WHERE ceipt.receiver.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM Receipt ceipt WHERE "
			+ "ceipt.receiver.id =:company "
			+ "AND ceipt.number LIKE %:key% "
			+ "ORDER BY ceipt.number DESC")
	public List<Receipt> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(ceipt) FROM Receipt ceipt WHERE "
			+ "ceipt.receiver.id =:company "
			+ "AND ceipt.number LIKE %:key% "
			+ "ORDER BY ceipt.number DESC")
	public Long count(@Param("company")String company,@Param("key")String key);
	
	@Query("FROM Receipt rcp WHERE "
			+ "rcp.receiver.id =:company "
			+ "AND rcp.efectiveDate BETWEEN :from AND :to "
			+ "ORDER BY rcp.efectiveDate ASC ")
	public List<Receipt> findAll(@Param("company")String company,@Param("from")Date from,@Param("to")Date to);
	
	@Query("FROM Receipt rcp WHERE "
			+ "rcp.efectiveDate BETWEEN :from AND :to "
			+ "ORDER BY rcp.efectiveDate ASC ")
	public List<Receipt> findAll(@Param("from")Date from,@Param("to")Date to);
}
