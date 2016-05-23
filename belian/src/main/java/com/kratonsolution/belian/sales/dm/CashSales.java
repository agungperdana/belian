/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.Geographic;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_sales")
public class CashSales extends Billable
{
	@Column(name="table_number")
	private int table = 1;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_location")
	private Geographic location;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_cashier_shift")
	private CashierShift shift;
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<CashSalesLine> items = new HashSet<CashSalesLine>();
	
	public CashSales(){}

	@Override
	public String getBillingType()
	{
		return "Cash Sales";
	}

	@Override
	public int getTableNumber()
	{
		return this.table;
	}
}
