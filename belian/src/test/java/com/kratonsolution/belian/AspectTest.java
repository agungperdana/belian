/**
 * 
 */
package com.kratonsolution.belian;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kratonsolution.belian.sales.dm.CashPayment;
import com.kratonsolution.belian.sales.dm.CashSales;
import com.kratonsolution.belian.sales.dm.SalesLine;
import com.kratonsolution.belian.sales.dm.srv.CashSalesService;

/**
 * @author agungdodiperdana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=EntryPoint.class)
@WebAppConfiguration
@IntegrationTest
public class AspectTest
{
	@Autowired
	private CashSalesService service;
	
	@Test
	public void aspectTest()
	{
		CashSales cash = new CashSales();
		cash.setId(UUID.randomUUID().toString());
		cash.setCustomerId(UUID.randomUUID().toString());
		cash.setCustomerName("John Banting");
		cash.setSalesId(UUID.randomUUID().toString());
		cash.setSalesName("John Kemot");
		
		for(int idx=0;idx<3;idx++)
		{
			SalesLine line = new SalesLine();
			line.setId(UUID.randomUUID().toString());
			line.setInventoryId(UUID.randomUUID().toString());
			line.setQuantity(BigDecimal.TEN);
			
			cash.getItems().add(line);
		}
		
		CashPayment payment = new CashPayment();
		payment.setId(UUID.randomUUID().toString());
		payment.setCashAccountId(UUID.randomUUID().toString());
		payment.setAmount(BigDecimal.valueOf(100000));
		
		cash.setPayment(payment);
		
		service.create(cash);
	}
}
