/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Strings;
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
	
	@Enumerated(EnumType.STRING)
	@Column(name="cash_sales_type")
	private CashSalesType type = CashSalesType.SHORTTERM;
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<CashSalesLine> items = new HashSet<CashSalesLine>();
	
	@OneToMany(mappedBy="shift")
	private Set<Billable> billings = new HashSet<>();
	
	public CashSales(){}

	@Override
	public String getBillingType(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
			return "Tunai";
		else
			return "Cash Sales";
	}

	@Override
	public int getTableNumber()
	{
		return this.table;
	}

	@Override
	public String getName()
	{
		return "Cash Sales";
	}
}
