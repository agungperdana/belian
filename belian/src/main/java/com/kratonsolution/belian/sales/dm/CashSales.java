/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

import com.kratonsolution.belian.global.EconomicAgent;
import com.kratonsolution.belian.global.ExchangeProccess;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="cash_sales_order")
public class CashSales extends Sales implements ExchangeProccess
{
	private CashPayment payment;
	
	private List<SalesLine> items = new ArrayList<SalesLine>();
	
	@Override
	public EconomicAgent getProducer()
	{		
		return getSales();
	}

	@Override
	public EconomicAgent getConsumer()
	{
		return getCustomer();
	}
	
	@Override
	public Collection<CashPayment> getIncrementEvents()
	{
		Collection<CashPayment> payments = new ArrayList<CashPayment>();
		payments.add(getPayment());
		
		return payments;
	}

	@Override
	public Collection<SalesLine> getDecrementEvents()
	{
		return getItems();
	}
}
