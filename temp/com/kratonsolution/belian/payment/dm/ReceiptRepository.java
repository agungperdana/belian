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
public interface ReceiptRepository extends JpaRepository<Receipt, String>
{
	@Query("FROM Receipt ipt WHERE "
			+ "ipt.organization.id IN(:company) "
			+ "ORDER BY ipt.date DESC ")
	public List<Receipt> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(ipt) FROM Receipt ipt WHERE "
			+ "ipt.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM Receipt ipt WHERE "
			+ "ipt.organization.id IN(:company) "
			+ "AND (ipt.reference LIKE %:key% OR ipt.note LIKE %:key%) "
			+ "ORDER BY ipt.date DESC ")
	public List<Receipt> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(ipt) FROM Receipt ipt WHERE "
			+ "ipt.organization.id IN(:company) "
			+ "AND (ipt.reference LIKE %:key% OR ipt.note LIKE %:key%) ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
}
