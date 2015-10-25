/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.global.dm.Contract;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_sales")
public class CashSales extends Contract<CashSalesPayment, CashSalesLine>
{
	public enum Status {PAID,UNPAID}
	
	@Column(name="table_number")
	private int table = 1;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status = Status.UNPAID;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_location")
	private Geographic location;
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CashSalesLine> decrements = new HashSet<CashSalesLine>();
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CashSalesPayment> increments = new HashSet<CashSalesPayment>();
	
	public CashSales(){}
	
	public BigDecimal getBill()
	{
		BigDecimal bill = BigDecimal.ZERO;
		
		for(CashSalesLine line:decrements)
			bill = bill.add(line.getPrice().multiply(line.getValue())).subtract(line.getDiscount()).add(line.getCharge());
		
		return bill;
	}
	
	public BigDecimal getTaxAmount()
	{
		return getBill().multiply(this.tax.getAmount().divide(BigDecimal.valueOf(100)));
	}
}
