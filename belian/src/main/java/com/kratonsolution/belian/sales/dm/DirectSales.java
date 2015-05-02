/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="direct_sales")
public class DirectSales extends Contract<DirectSalesPayment, DirectSalesLine>
{
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_location")
	private Geographic location;
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<DirectSalesLine> decrements = new HashSet<DirectSalesLine>();
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<DirectSalesPayment> increments = new HashSet<DirectSalesPayment>();
}
