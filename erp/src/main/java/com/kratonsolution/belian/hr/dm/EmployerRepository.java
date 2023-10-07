
package com.kratonsolution.belian.hr.dm;

import com.kratonsolution.belian.party.impl.orm.PartyRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public interface EmployerRepository extends JpaRepository<Employer, String>
{
	@Query("FROM Employer emp WHERE emp.party.id =:company AND emp.type = 'EMPLOYER' ")
	public Employer findEmployer(@Param("company")String company);
	
	public List<Employer> findAllByPartyIdAndType(String party, PartyRoleType type);
}
