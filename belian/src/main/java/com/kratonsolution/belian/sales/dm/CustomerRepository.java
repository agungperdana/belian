/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CustomerRepository extends JpaRepository<Customer, String>
{
	
	@Query("FROM Customer cm WHERE cm.company.id =:company ORDER BY cm.party.name ASC")
	public List<Customer> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT DISTINCT(cm) FROM Customer cm WHERE cm.company.id =:company")
	public Long count(@Param("company")String company);
}
