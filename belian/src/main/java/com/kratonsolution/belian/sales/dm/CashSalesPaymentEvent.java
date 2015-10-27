/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.accounting.dm.GLAccount;
import com.kratonsolution.belian.global.dm.EconomicEvent;
import com.kratonsolution.belian.global.dm.EconomicType;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_sales_payment_event")
public class CashSalesPaymentEvent extends EconomicEvent<GLAccount>
{	
	@ManyToOne
	@JoinColumn(name="fk_gl_account")
	private GLAccount resource;
	
	public CashSalesPaymentEvent()
	{
		setEconomicType(EconomicType.FINANCIAL);
	}
}