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
public interface LaboratorySalesRepository extends JpaRepository<LaboratorySales, String>
{
	@Query("FROM LaboratorySales lab WHERE lab.organization.id =:company ORDER BY lab.date DESC")
	public List<LaboratorySales> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("FROM LaboratorySales lab WHERE lab.organization.id =:company AND lab.status = 'Registered' AND lab.paid IS true ORDER BY lab.date DESC")
	public List<LaboratorySales> findAllPaid(@Param("company")String company);

	@Query("SELECT COUNT(lab) FROM LaboratorySales lab WHERE lab.organization.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("SELECT COUNT(lab) FROM LaboratorySales lab WHERE lab.organization.id =:company AND lab.paid IS true AND lab.status = 'Registered'")
	public Long countPaid(@Param("company")String company);
}
