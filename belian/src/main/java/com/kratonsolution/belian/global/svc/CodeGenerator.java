package com.kratonsolution.belian.global.svc;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.global.dm.SequenceNumber;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.dm.SequenceNumberRepository;

/**
 * 
 */

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CodeGenerator
{
	@Autowired
	private SequenceNumberRepository repository;
	
	@Autowired
	private SessionUtils utils;
	
	public String generate(Date date,Organization organization,Code code)
	{
		StringBuilder builder = new StringBuilder();
		builder.append(code.toString().toUpperCase());
		
		SequenceNumber number = repository.findOneByCompanyIdAndDateAndCode(organization.getId(),date,code);
		if(number == null)
		{
			number = new SequenceNumber();
			number.setCode(code);
			number.setCompanyId(organization.getId());
			number.setDate(date);
			number.setSequence(2);
			
			builder.append("1");
			
			repository.save(number);
		}
		else
		{
			builder.append(number.getSequence());
			
			number.setSequence(number.getSequence()+1);
			repository.save(number);
		}
		
		return builder.toString();
	}
	
	public String generate(Code code)
	{
		return generate(DateTimes.currentDate(),utils.getOrganization(),code);
	}
}
