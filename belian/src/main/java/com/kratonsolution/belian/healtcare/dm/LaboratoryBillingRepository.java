/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface LaboratoryBillingRepository extends JpaRepository<LaboratoryBilling, String>
{
	@Query("FROM LaboratoryBilling bil WHERE bil.organization.id =:company AND bil.paid IS true AND bil.status = 'REGISTERED' ORDER BY bil.number ASC")
	public List<LaboratoryBilling> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(bil) FROM LaboratoryBilling bil WHERE bil.organization.id =:company AND bil.paid IS true AND bil.status = 'REGISTERED'")
	public Long count(@Param("company")String company);
}
