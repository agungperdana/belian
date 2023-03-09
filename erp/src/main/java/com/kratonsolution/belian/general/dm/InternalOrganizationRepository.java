
package com.kratonsolution.belian.general.dm;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface InternalOrganizationRepository extends JpaRepository<InternalOrganization, String>
{
	public InternalOrganization getOneByPartyId(String id);
	
	@Query("FROM InternalOrganization int WHERE "
			+ "int.party.id =:company "
			+ "AND ((:date BETWEEN int.start AND int.end) OR (int.start <= :date AND int.end IS NULL))")
	public InternalOrganization getOne(@Param("company")String company,@Param("date")Date date);
}
