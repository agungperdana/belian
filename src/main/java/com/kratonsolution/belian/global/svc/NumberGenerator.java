package com.kratonsolution.belian.global.svc;
import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.common.DateTimes;
import com.kratonsolution.belian.common.SessionUtils;
import com.kratonsolution.belian.global.dm.SequenceNumber;
import com.kratonsolution.belian.global.dm.SequenceNumber.Code;
import com.kratonsolution.belian.global.dm.SequenceNumberRepository;



/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class NumberGenerator
{
	@Autowired
	private SequenceNumberRepository repository;
	
	@Autowired
	private SessionUtils utils;
	
	public String generate(Date date,String organization,Code code)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		StringBuilder builder = new StringBuilder();
		builder.append(code.toString().toUpperCase()+"-");
		builder.append(calendar.get(Calendar.DAY_OF_MONTH)<10?"0"+(calendar.get(Calendar.DAY_OF_MONTH)):calendar.get(Calendar.DAY_OF_MONTH));
		builder.append(calendar.get(Calendar.MONTH)<10?"0"+(calendar.get(Calendar.MONTH)+1):calendar.get(Calendar.MONTH)+1);
		builder.append(calendar.get(Calendar.YEAR)+"-");
		
		SequenceNumber number = repository.findByCompanyIdAndDateAndCode(organization,date,code);
		if(number == null)
		{
			number = new SequenceNumber();
			number.setCode(code);
			number.setCompanyId(organization);
			number.setDate(date);
			number.setSequence(2);
			
			builder.append("1");
			
			repository.save(number);
		}
		else
		{
			builder.append(number.getSequence());
			number.plus();
			repository.save(number);
		}
		
		return builder.toString();
	}
	
	public String generate(Code code)
	{
		if(utils.getOrganization() == null)
			throw new RuntimeException("Empty organization");
		
		return generate(DateTimes.currentDate(),utils.getOrganization().getId(),code);
	}
	
	public int nextQueue(Code code)
	{
		if(code == null || utils.getOrganization() == null)
			return 0;
		
		SequenceNumber sequence = repository.findByCompanyIdAndDateAndCode(utils.getOrganization().getId(), DateTimes.currentDate(), code);
		if(sequence == null)
		{
			sequence = new SequenceNumber();
			sequence.setCode(code);
			sequence.setCompanyId(utils.getOrganization().getId());
			sequence.setDate(DateTimes.currentDate());
			sequence.setSequence(1);
			
			repository.save(sequence);
			return 1;
		}
		else
		{
			int number = sequence.getSequence()+1;
			sequence.setSequence(number);
			repository.save(sequence);
			
			return number;
		}
	}
}
