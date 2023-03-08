
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.partys.dm.PartyRoleType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EmployerRepository extends JpaRepository<Employer, String>
{
	@Query("FROM Employer emp WHERE emp.party.id =:company AND emp.type = 'EMPLOYER' ")
	public Employer findEmployer(@Param("company")String company);
	
	public List<Employer> findAllByPartyIdAndType(String party,PartyRoleType type);
}
