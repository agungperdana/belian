/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.sales.dm.Billable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * A RECEIPT subtype represents incoming moneys to an internal organization of the enterprise.
 */
@Getter
@Setter
@Entity
@Table(name="receipt")
public class Receipt extends Payment
{
	@ManyToOne
	@JoinColumn(name="fk_billable")
	private Billable billable;
	
	public Receipt(){}
}
