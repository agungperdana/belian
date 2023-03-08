/**
 * 
 */
package com.kratonsolution.belian.payments.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="payment_application")
public class PaymentApplication implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="amount")
	private BigDecimal amount = BigDecimal.ZERO;
	
	@Embedded
	private InvoiceRef invoice;
	
	@ManyToOne
	@JoinColumn(name="fk_payment")
	private Payment payment;
	
	@Version
	private Long version;
	
	@Override
	public String getLabel()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
