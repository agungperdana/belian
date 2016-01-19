/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.general.dm.PartyRole.Type;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DoctorRepository extends JpaRepository<Doctor, String>
{
	public Doctor findOneByPartyIdAndType(String id,Type type);

	@Query("SELECT DISTINCT(partner.child) FROM DoctorPartnership partner WHERE partner.parent.party.id IN(:companys)")
	public List<Doctor> findAllForCompanys(@Param("companys")Collection<String> companys);
	
	@Query("SELECT DISTINCT(partner.child) FROM DoctorPartnership partner WHERE partner.parent.party.id =:company")
	public List<Doctor> findAllPartners(@Param("company")String companys);
	
	@Query("FROM Doctor doc WHERE doc.party.id =:person")
	public List<Doctor> findAllByPerson(@Param("person")String person);
	
	@Query("FROM Doctor doc WHERE doc.company.id =:company ORDER BY doc.party.name ASC")
	public List<Doctor> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("FROM Doctor doc WHERE doc.company.id =:company ORDER BY doc.party.name ASC")
	public List<Doctor> findAll(@Param("company")String company);
	
	@Query("SELECT COUNT(doc) FROM Doctor doc WHERE doc.company.id =:company")
	public Long count(@Param("company")String company);
	
	@Query("FROM Doctor doc WHERE doc.party.name LIKE :name% AND doc.company.id =:company ORDER BY doc.party.name ASC")
	public List<Doctor> findAll(@Param("name")String name,@Param("company")String company);

	public Doctor findOneByPartyNameAndCompanyId(String name,String company);
}
