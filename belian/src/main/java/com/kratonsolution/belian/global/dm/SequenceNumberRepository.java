/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.global.dm.SequenceNumber.Code;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface SequenceNumberRepository extends JpaRepository<SequenceNumber, String>
{
	public SequenceNumber findOneByCompanyIdAndDateAndCode(String companyId,Date date,Code code);
}
