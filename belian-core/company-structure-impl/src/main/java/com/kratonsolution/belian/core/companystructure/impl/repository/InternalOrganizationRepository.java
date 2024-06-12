package com.kratonsolution.belian.core.companystructure.impl.repository;

import java.sql.Date;

import com.kratonsolution.belian.core.companystructure.impl.orm.InternalOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface InternalOrganizationRepository extends JpaRepository<InternalOrganization, String>
{
	public InternalOrganization findByPartyId(String id);
	
	@Query("FROM InternalOrganization int WHERE "
			+ "int.party.id =:company "
			+ "AND ((:date BETWEEN int.start AND int.end) OR (int.start <= :date AND int.end IS NULL))")
	public InternalOrganization findById(@Param("company")String company,@Param("date")Date date);
}
