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
public interface LaboratoryRepository extends JpaRepository<Laboratory, String>
{
	@Query("FROM Laboratory lab WHERE lab.organization.id =:company ORDER BY lab.date DESC")
	public List<Laboratory> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("FROM Laboratory lab WHERE lab.organization.id =:company AND lab.status = 'Registered' AND lab.paid IS true ORDER BY lab.date DESC")
	public List<Laboratory> findAllPaid(@Param("company")String company);

	@Query("SELECT COUNT(lab) FROM Laboratory lab WHERE lab.organization.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("SELECT COUNT(lab) FROM Laboratory lab WHERE lab.organization.id =:company AND lab.paid IS true AND lab.status = 'Registered'")
	public Long countPaid(@Param("company")String company);
}
