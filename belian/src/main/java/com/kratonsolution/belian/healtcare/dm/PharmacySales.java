/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Strings;
import com.kratonsolution.belian.invoice.dm.PaymentApplication;
import com.kratonsolution.belian.sales.dm.BillableItem;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="pharmacy_sales")
public class PharmacySales extends MedicalSales
{
	@Column(name="is_reference")
	private boolean reference;
	
	@OneToMany(mappedBy="pharmacySales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PharmacySalesItem> items = new HashSet<>();
	
	public PharmacySales(){}

	@Override
	public String getBillingType(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
			return "Apotik";
		else
			return "Apotek";
	}

	@Override
	public String getName()
	{
		return "Pharmacy Sales";
	}
	
	public BigDecimal getCostTax()
	{
		BigDecimal cTax = BigDecimal.ZERO;
		for(PharmacySalesItem item:getItems())
			cTax = cTax.add(item.getCost().multiply(BigDecimal.valueOf(0.1)));
		
		return cTax;
	}
	
	public BigDecimal getBillingAmount()
	{
		BigDecimal amount = BigDecimal.ZERO;
		
		for(BillableItem item:getItems())
			amount = amount.add(item.getQuantity().multiply(item.getUnitPrice()));
		
		return amount.add(tuslah).add(rounding);
	}
	
	public BigDecimal getTaxAmount()
	{
		if(tax != null)
			return getBillingAmount().multiply(tax.getAmount().divide(BigDecimal.valueOf(100)));
		
		return BigDecimal.ZERO;
	}
	
	public boolean match()
	{
		BigDecimal paids = BigDecimal.ZERO;
		for(PaymentApplication application:getReceipts())
			paids = paids.add(application.getAmount());
		
		return(paids.compareTo(getBillingAmount().add(getTaxAmount())) == 0);
	}
	
	public BigDecimal getNet()
	{
		return getBillingAmount().subtract(getTaxAmount());
	}
	
	@Override
	public BigDecimal getExtra()
	{
		return getTuslah().add(rounding);

	}
}
