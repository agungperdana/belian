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
public interface LaboratoryRegistrationRepository extends JpaRepository<LaboratoryRegistration, String>
{
	@Query("FROM LaboratoryRegistration lab WHERE lab.organization.id =:company ORDER BY lab.date DESC")
	public List<LaboratoryRegistration> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(lab) FROM LaboratoryRegistration lab WHERE lab.organization.id =:company")
	public Long count(@Param("company")String company);
}
