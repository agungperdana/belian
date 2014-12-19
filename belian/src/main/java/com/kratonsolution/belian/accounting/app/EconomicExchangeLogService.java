/**
 * 
 */
package com.kratonsolution.belian.accounting.app;

import java.util.UUID;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.accounting.dm.EconomicExchangeLog;
import com.kratonsolution.belian.accounting.dm.EconomicExchangeLogRepository;
import com.kratonsolution.belian.accounting.dm.EconomicExchangeLog.Type;
import com.kratonsolution.belian.global.DecrementEvent;
import com.kratonsolution.belian.global.ExchangeProccess;
import com.kratonsolution.belian.global.IncrementEvent;

/**
 * @author agungdodiperdana
 *
 */
@Service
@Aspect
public class EconomicExchangeLogService
{
	@Autowired
	private EconomicExchangeLogRepository repository;
	
	@AfterReturning("@annotation(com.kratonsolution.belian.global.EconomicExchangeEvent) && args(proccess,..)")
	public void record(ExchangeProccess proccess)
	{
		for(IncrementEvent event:proccess.getIncrementEvents())
		{
			EconomicExchangeLog log = new EconomicExchangeLog();
			log.setId(UUID.randomUUID().toString());
			log.setDate(proccess.getDate());
			log.setName(event.getEventName());
			log.setType(Type.INCREMENT);
			log.setValue(event.getValue());
			
			repository.save(log);
		}
		
		for(DecrementEvent event:proccess.getDecrementEvents())
		{
			EconomicExchangeLog log = new EconomicExchangeLog();
			log.setId(UUID.randomUUID().toString());
			log.setDate(proccess.getDate());
			log.setName(event.getEventName());
			log.setType(Type.DECREMENT);
			log.setValue(event.getValue());
		
			repository.save(log);
		}
	}
}
