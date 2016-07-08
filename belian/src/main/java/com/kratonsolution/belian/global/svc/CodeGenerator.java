package com.kratonsolution.belian.global.svc;
import java.sql.Date;
import java.util.Calendar;

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
	
	public int nextQueue(Code code)
	{
		if(code == null || utils.getOrganization() == null)
			return 0;
		
		SequenceNumber sequence = repository.findOneByCompanyIdAndDateAndCode(utils.getOrganization().getId(), DateTimes.currentDate(), code);
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
	
	public String studentID(String company)
	{
		StringBuilder builder = new StringBuilder();
		builder.append(SequenceNumber.Code.SDN);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		
		builder.append(calendar.get(Calendar.YEAR));
		
		if(calendar.get(Calendar.MONTH) < 10)
			builder.append("0").append(calendar.get(Calendar.MONTH)+1);
		else
			builder.append(calendar.get(Calendar.MONTH)+1);
		
		SequenceNumber number = repository.findOne(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), company);
		if(number == null)
		{
			builder.append("0001");
			
			number = new SequenceNumber();
			number.setCode(Code.SDN);
			number.setCompanyId(company);
			number.setMonth(calendar.get(Calendar.MONTH));
			number.setYear(calendar.get(Calendar.YEAR));
			number.setSequence(2);
			
			repository.save(number);
		}
		else
		{
			if(number.getSequence() < 10)
				builder.append("000").append(number.getSequence());
			else if(number.getSequence() < 100)
				builder.append("00").append(number.getSequence());
			else 
				builder.append("0").append(number.getSequence());
		
			number.setSequence(number.getSequence()+1);
			repository.save(number);
		}
		
		return builder.toString();
	}
}
