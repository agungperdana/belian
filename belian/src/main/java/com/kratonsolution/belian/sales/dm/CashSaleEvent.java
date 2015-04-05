/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kratonsolution.belian.global.EconomicEvent;

/**
 * @author agungdodiperdana
 *
 */
@Entity
@Table(name="sale")
public class CashSaleEvent implements EconomicEvent
{
	@Id
	private String id;
	
	@Override
	public String getId()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id)
	{
		// TODO Auto-generated method stub
		
	}
}
