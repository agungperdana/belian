/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.svc.Journalable;
import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.invoice.dm.PaymentApplication;
import com.kratonsolution.belian.partys.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cashier_shift")
public class CashierShift implements Serializable,Journalable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;

	@ManyToOne
	@JoinColumn(name="employee")
	private Person employee;
	
	@ManyToOne
	@JoinColumn(name="asset")
	private Asset machine;
	
	@Column(name="capital")
	private BigDecimal capital = BigDecimal.ZERO;
	
	@Column(name="start")
	private Time start;
	
	@Column(name="end")
	private Time end;
	
	@Column(name="is_closed")
	private boolean closed;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	private Currency currency;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="shift")
	private Set<Billable> billings = new HashSet<>();
	
	public CashierShift(){}
	
	public BigDecimal getAmount()
	{
		BigDecimal amount = BigDecimal.ZERO;
				
		for(Billable billable:billings)
		{
			for(PaymentApplication application:billable.getReceipts())
			{
//				if(application.getReceipt().getType().getName().equals("Cash"))
//					amount = amount.add(application.getAmount());
			}
		}
		
		return amount;
	}
	
	public BigDecimal getTax()
	{
		BigDecimal amount = BigDecimal.ZERO;
				
		for(Billable billable:billings)
			amount = amount.add(billable.getTaxAmount());
		
		return amount;
	}
	
	public BigDecimal getTotalAmount()
	{
		return capital.add(getAmount()).add(getTax());
	}
}
