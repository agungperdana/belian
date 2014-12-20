/**
 * 
 */
package com.kratonsolution.belian.global.dm.srv;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.global.dm.DocumentNumber;
import com.kratonsolution.belian.global.dm.DocumentNumber.Type;
import com.kratonsolution.belian.global.dm.DocumentNumberRepository;

/**
 * @author agungdodiperdana
 *
 */
@Service
public class DocumentNumberService
{
	@Autowired
	private DocumentNumberRepository repository;
	
	public String nextForType(Type type)
	{
		StringBuilder builder = new StringBuilder();
		int index = 1;
		
		DocumentNumber number = repository.findOneByType(type);
		if(number == null)
		{
			number = new DocumentNumber();
			number.setId(UUID.randomUUID().toString());
			number.setType(type);
			number.setIndex(index);
			
			repository.save(number);
		}
		else
		{
			number.next();
			repository.save(number);
			
			index = number.getIndex();
		}
		
		builder.append(type.toString()).append(" ");
		
		if(index < 10)
			builder.append("0000000").append(index);
		else if(index < 100)
			builder.append("000000").append(index);
		else if(index < 1000)
			builder.append("00000").append(index);
		else if(index < 10000)
			builder.append("0000").append(index);
		else if(index < 100000)
			builder.append("000").append(index);
		else if(index < 1000000)
			builder.append("00").append(index);
		else if(index < 10000000)
			builder.append("0").append(index);
		
		return builder.toString();
	}
}
