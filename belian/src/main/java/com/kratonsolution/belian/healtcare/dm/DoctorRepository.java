/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.Collection;
import java.util.List;

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
}
