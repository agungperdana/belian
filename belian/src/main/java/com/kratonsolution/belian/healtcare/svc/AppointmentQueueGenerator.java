/**
 * 
 */
package com.kratonsolution.belian.healtcare.svc;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.global.dm.SequenceNumber;
import com.kratonsolution.belian.global.dm.SequenceNumberRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */

@Service
@Transactional(rollbackFor=Exception.class)
public class AppointmentQueueGenerator
{
	@Autowired
	private SequenceNumberRepository repository;

	public int next(Date date,String personId,String companyId)
	{
		SequenceNumber number = repository.findOneByDateAndPersonIdAndCompanyId(date, personId, companyId);
		if(number != null)
		{
			int now = number.getSequence();
			number.setSequence(now+1);
			repository.save(number);
			
			return now;
		}
		else
		{
			number = new SequenceNumber();
			number.setDate(date);
			number.setCompanyId(companyId);
			number.setPersonId(personId);
			
			repository.save(number);
			
			return number.getSequence();
		}
	}
}
