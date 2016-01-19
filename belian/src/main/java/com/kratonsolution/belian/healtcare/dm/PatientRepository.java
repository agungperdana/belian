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
public interface PatientRepository extends JpaRepository<Patient, String>
{
	public Patient findOneByBpjsCard(String bpjsCardNumber);
	
	@Query("FROM Patient pat WHERE pat.party.id =:person AND pat.company.id =:company")
	public Patient findOne(@Param("person")String person,@Param("company")String company);

	@Query("FROM Patient pat WHERE pat.company.id =:company ORDER BY pat.party.name")
	public List<Patient> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("FROM Patient pat WHERE pat.company.id =:company ORDER BY pat.party.name")
	public List<Patient> findAll(@Param("company")String company);
	
	@Query("SELECT COUNT(pat) FROM Patient pat WHERE pat.company.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM Patient pat WHERE pat.party.name LIKE :name% AND pat.company.id =:company ORDER BY pat.party.name ASC")
	public List<Patient> findAll(@Param("name")String name,@Param("company")String company);

	public Patient findOneByPartyNameAndCompanyId(String name,String company);
}