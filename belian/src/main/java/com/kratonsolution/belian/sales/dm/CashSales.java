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
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.Contract;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="cash_sales")
public class CashSales extends Contract<PaymentLine, CashLine>
{
	@ManyToOne
	@JoinColumn(name="fk_person_sales")
	private Person sales;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CashLine> decrements = new HashSet<CashLine>();
	
	@OneToMany(mappedBy="cashSales",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PaymentLine> increments = new HashSet<PaymentLine>();
}
