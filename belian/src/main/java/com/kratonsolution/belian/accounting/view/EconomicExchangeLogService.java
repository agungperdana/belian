/**
 * 
 */
package com.kratonsolution.belian.accounting.view;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import com.kratonsolution.belian.global.ExchangeProccess;

/**
 * @author agungdodiperdana
 *
 */
@Aspect
public class EconomicExchangeLogService
{
	@AfterReturning("args(proccess)")
	public void record(ExchangeProccess proccess)
	{
		System.out.println(proccess);
		System.out.println(proccess.getClass().getName());
	}
}
