/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SequenceNumberRepository extends JpaRepository<SequenceNumber, String>
{
	public SequenceNumber findOneByDateAndPersonIdAndCompanyId(Date date,String personId,String companyId);
}
