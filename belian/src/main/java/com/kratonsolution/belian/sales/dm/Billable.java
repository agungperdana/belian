/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.accounting.dm.Currency;
import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.accounting.svc.Journalable;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Party;
import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="billable")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Billable implements Journalable,Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	protected String number;
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="is_paid")
	protected boolean paid;
	
	@Column(name="rounding")
	protected BigDecimal rounding;
	
	@ManyToOne
	@JoinColumn(name="fk_currency")
	protected Currency currency;

	@ManyToOne
	@JoinColumn(name="fk_organization")
	protected Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_person_sales")
	protected Person sales;
	
	@ManyToOne
	@JoinColumn(name="fk_person_customer")
	protected Party customer;
	
	@ManyToOne
	@JoinColumn(name="fk_tax")
	protected Tax tax;
	
	@ManyToOne
	@JoinColumn(name="fk_cashier_shift")
	protected CashierShift shift;
	
	@Version
	protected Long version;

	@OneToMany(mappedBy="billable",fetch=FetchType.EAGER)
	private Set<PaymentApplication> receipts = new HashSet<>();
	
	public Billable(){}
	
	public abstract Set<? extends BillableItem> getItems();

	public abstract String getBillingType(String lang);
	
	public abstract int getTableNumber();
	
	public abstract String getName();
	
	public BigDecimal getExtra()
	{
		return BigDecimal.ZERO;
	}
	
	public BigDecimal getBillingAmount()
	{
		BigDecimal amount = BigDecimal.ZERO;
		
		for(BillableItem item:getItems())
			amount = amount.add(item.getQuantity().multiply(item.getUnitPrice()));
		
		return amount;
	}
	
	public BigDecimal getTaxAmount()
	{
		if(tax != null)
			return getBillingAmount().multiply(tax.getAmount().divide(BigDecimal.valueOf(100),RoundingMode.HALF_UP));
		
		return BigDecimal.ZERO;
	}
	
	public boolean match()
	{
		BigDecimal paids = BigDecimal.ZERO;
		for(PaymentApplication application:receipts)
			paids = paids.add(application.getAmount());
		
		return(paids.compareTo(getBillingAmount().add(getTaxAmount())) == 0);
	}
	
	public BigDecimal getNet()
	{
		return getBillingAmount().subtract(getTaxAmount());
	}
}
