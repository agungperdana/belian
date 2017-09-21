/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.global.dm.SequenceNumber.Code;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SequenceNumberRepository extends JpaRepository<SequenceNumber, String>
{
	public SequenceNumber findOneByDateAndPersonIdAndCompanyId(Date date,String personId,String companyId);

	public SequenceNumber findOneByCompanyIdAndDateAndCode(String companyId,Date date,Code code);

	@Query("FROM SequenceNumber num WHERE "
			+ "num.year =:year "
			+ "AND num.month =:month "
			+ "AND companyId =:company")
	public SequenceNumber findOne(@Param("year")int year,@Param("month")int month,@Param("company")String company);
}
