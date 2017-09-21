/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

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
public interface StockAdminRepository extends JpaRepository<StockAdmin, String>
{
	@Query("FROM StockAdmin adm WHERE adm.organization.party.id =:company ORDER BY adm.employee.party.name ASC")
	public List<StockAdmin> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(adm) FROM StockAdmin adm WHERE adm.organization.party.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM StockAdmin adm WHERE "
			+ "adm.employee.party.id =:person "
			+ "AND adm.organization.party.id =:company "
			+ "AND ((:date BETWEEN adm.start AND adm.end) OR (adm.start <= :date AND adm.end IS NULL))")
	public StockAdmin findOne(@Param("date")Date date ,@Param("person")String person,@Param("company")String company);
}
